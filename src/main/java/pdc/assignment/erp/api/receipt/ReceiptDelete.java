package pdc.assignment.erp.api.receipt;

import pdc.assignment.erp.dbo.entity.ReceiptDetailsEntity;
import pdc.assignment.erp.dbo.service.ReceiptDetailServiceImpl;
import pdc.assignment.erp.dbo.service.ReceiptServiceImpl;

import java.util.List;

public class ReceiptDelete {

    private ReceiptDelete(){
        throw new IllegalStateException("Utility class");
    }

    public static boolean orderDelete(int rid){

        ReceiptDetailServiceImpl receiptDetailService = new ReceiptDetailServiceImpl();

        List<ReceiptDetailsEntity> list = receiptDetailService.selectDidReceiptDetails(rid);

        for(ReceiptDetailsEntity receiptDetailsEntity : list){
            receiptDetailService.deleteReceiptDetail(receiptDetailsEntity);
        }

        ReceiptServiceImpl receiptService = new ReceiptServiceImpl();

        receiptService.deleteReceipt(receiptService.selectRidReceipt(rid));

        return true;
    }
}
