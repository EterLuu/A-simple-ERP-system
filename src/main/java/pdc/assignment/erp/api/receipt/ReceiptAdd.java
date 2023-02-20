package pdc.assignment.erp.api.receipt;

import pdc.assignment.erp.dbo.entity.ReceiptDetailsEntity;
import pdc.assignment.erp.dbo.entity.ReceiptsEntity;
import pdc.assignment.erp.dbo.service.*;
import pdc.assignment.erp.util.Judgement;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

public class ReceiptAdd {

    private ReceiptAdd(){
        throw new IllegalStateException("Utility class");
    }

    public static boolean receiptAdd(String customer, String user, Timestamp timestamp, List<ReceiptDetailsEntity> data, String remark){
        if(!Judgement.judgeName(customer)){
            return false;
        }
        if(!Judgement.judgeName(user)){
            return false;
        }
        if(data.isEmpty()){
            return false;
        }
        if(!Judgement.judgeLongString(remark)){
            return false;
        }

        CustomerServiceImpl customerService = new CustomerServiceImpl();
        UserServiceImpl userService = new UserServiceImpl();
        ReceiptDetailServiceImpl receiptDetailService = new ReceiptDetailServiceImpl();
        ReceiptServiceImpl receiptService = new ReceiptServiceImpl();

        ReceiptsEntity receiptsEntity = new ReceiptsEntity();

        receiptsEntity.setCid(customerService.selectCustomer(customer).getCid());
        receiptsEntity.setUid(userService.selectUser(user).getUid());
        receiptsEntity.setTime(timestamp);
        receiptsEntity.setRemark(remark);

        BigDecimal totalBalance = new BigDecimal(0);

        for (ReceiptDetailsEntity receiptDetailsEntity : data){
            totalBalance = totalBalance.add(receiptDetailsEntity.getBalance().add(receiptDetailsEntity.getBalance()));
        }

        if(totalBalance.compareTo(BigDecimal.valueOf(1e+17)) > 0){
            return false;
        }

        receiptsEntity.setBalance(totalBalance);

        int rid = receiptService.insertReceipt(receiptsEntity);

        if(rid == -1){
            return false;
        }

        for (ReceiptDetailsEntity receiptDetailsEntity : data){
            receiptDetailsEntity.setRid(rid);
            receiptDetailService.insertReceiptDetail(receiptDetailsEntity);
        }

        return true;
    }
}
