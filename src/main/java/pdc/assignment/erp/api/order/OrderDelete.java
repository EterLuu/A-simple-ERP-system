package pdc.assignment.erp.api.order;

import pdc.assignment.erp.dbo.entity.OrderDetailsEntity;
import pdc.assignment.erp.dbo.service.OrderDetailServiceImpl;
import pdc.assignment.erp.dbo.service.OrderServiceImpl;

import java.util.List;

public class OrderDelete {

    private OrderDelete(){
        throw new IllegalStateException("Utility class");
    }

    public static boolean orderDelete(int oid){

        OrderDetailServiceImpl orderDetailService = new OrderDetailServiceImpl();

        List<OrderDetailsEntity> list = orderDetailService.selectOidOrderDetails(oid);

        for(OrderDetailsEntity orderDetailsEntity : list){
            orderDetailService.deleteOrderDetail(orderDetailsEntity);
        }

        OrderServiceImpl orderService = new OrderServiceImpl();

        orderService.deleteOrder(orderService.selectOidOrder(oid));

        return true;
    }
}
