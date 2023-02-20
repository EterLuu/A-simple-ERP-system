package pdc.assignment.erp.api.order;

import pdc.assignment.erp.dbo.entity.OrderDetailsEntity;
import pdc.assignment.erp.dbo.entity.OrdersEntity;
import pdc.assignment.erp.dbo.service.*;
import pdc.assignment.erp.util.Judgement;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

public class OrderAdd {

    private OrderAdd(){
        throw new IllegalStateException("Utility class");
    }

    public static boolean orderAdd(String customer, String user, Timestamp timestamp, List<OrderDetailsEntity> data, String remark){
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
        OrderDetailServiceImpl orderDetailService = new OrderDetailServiceImpl();
        OrderServiceImpl orderService = new OrderServiceImpl();

        OrdersEntity ordersEntity = new OrdersEntity();

        ordersEntity.setCid(customerService.selectCustomer(customer).getCid());
        ordersEntity.setUid(userService.selectUser(user).getUid());
        ordersEntity.setTime(timestamp);
        ordersEntity.setRemark(remark);

        BigDecimal totalPrice = new BigDecimal(0);

        for (OrderDetailsEntity orderDetailsEntity : data){
            totalPrice = totalPrice.add(orderDetailsEntity.getPrice().multiply(orderDetailsEntity.getNumber()));
        }

        if(totalPrice.compareTo(BigDecimal.valueOf(1e+17)) > 0) {
            return false;
        }

        ordersEntity.setPrice(totalPrice);

        int oid = orderService.insertOrder(ordersEntity);

        if(oid == -1){
            return false;
        }

        for (OrderDetailsEntity orderDetailsEntity : data){
            orderDetailsEntity.setOid(oid);
            orderDetailService.insertOrderDetail(orderDetailsEntity);
        }

        return true;
    }
}
