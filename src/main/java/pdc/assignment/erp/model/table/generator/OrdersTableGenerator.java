package pdc.assignment.erp.model.table.generator;

import pdc.assignment.erp.dbo.entity.CustomersEntity;
import pdc.assignment.erp.dbo.service.CustomerServiceImpl;
import pdc.assignment.erp.dbo.service.OrderServiceImpl;
import pdc.assignment.erp.model.table.OrdersTableModel;

public class OrdersTableGenerator {

    private OrdersTableGenerator(){
        throw new IllegalStateException("Utility class");
    }

    public static OrdersTableModel searchOrders() {
        OrderServiceImpl orderService = new OrderServiceImpl();

        return new OrdersTableModel(orderService.selectOrders());
    }

    public static OrdersTableModel searchOrders(String name) {
        OrderServiceImpl orderService = new OrderServiceImpl();
        CustomerServiceImpl customerService = new CustomerServiceImpl();

        CustomersEntity customer = customerService.selectCustomer(name);

        if(customer != null)
            return new OrdersTableModel(orderService.selectCidOrders(customer.getCid()));
        else
            return new OrdersTableModel(orderService.selectOrders());
    }
}
