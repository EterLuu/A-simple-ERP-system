package pdc.assignment.erp.api.customer;

import pdc.assignment.erp.dbo.entity.CustomersEntity;
import pdc.assignment.erp.dbo.service.CustomerServiceImpl;

public class CustomerDelete {

    private CustomerDelete(){
        throw new IllegalStateException("Utility class");
    }

    public static boolean customerUpdate(int cid){

        CustomerServiceImpl customerService = new CustomerServiceImpl();

        CustomersEntity customer = customerService.selectCustomer(cid);

        if (customer == null)
            return false;

        return customerService.deleteCustomer(customer);
    }
}
