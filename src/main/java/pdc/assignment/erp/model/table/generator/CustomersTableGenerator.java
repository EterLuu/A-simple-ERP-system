package pdc.assignment.erp.model.table.generator;

import pdc.assignment.erp.dbo.service.CustomerServiceImpl;
import pdc.assignment.erp.model.table.CustomersTableModel;
import pdc.assignment.erp.util.Judgement;

public class CustomersTableGenerator {

    private CustomersTableGenerator(){
        throw new IllegalStateException("Utility class");
    }
    private static CustomerServiceImpl customerService = new CustomerServiceImpl();

    public static CustomersTableModel searchCustomer(String name) {

        // Prevent SQL injection.
        if(!Judgement.judgeName(name)){
            return new CustomersTableModel(customerService.selectCustomers());
        }

        return new CustomersTableModel(customerService.selectCustomers(name));
    }

    public static CustomersTableModel searchCustomer() {

        return new CustomersTableModel(customerService.selectCustomers());
    }
}
