package pdc.assignment.erp.api.customer;

import pdc.assignment.erp.dbo.entity.CustomersEntity;
import pdc.assignment.erp.dbo.service.CustomerServiceImpl;
import pdc.assignment.erp.util.Judgement;

public class CustomerAdd {

    private CustomerAdd(){
        throw new IllegalStateException("Utility class");
    }

    public static boolean customerAdd(String name, String address, String telephone, String fax, String remark){

        // Prevent SQL injection.
        if(!(Judgement.judgeName(name))){
            return false;
        }
        if(!(Judgement.judgeStringWithoutEmpty(address))){
            return false;
        }
        if(!(Judgement.judgeStringWithoutEmpty(telephone))){
            return false;
        }
        if(!(Judgement.judgeStringWithoutEmpty(fax))){
            return false;
        }
        if(!(Judgement.judgeLongString(remark))){
            return false;
        }

        CustomerServiceImpl customerService = new CustomerServiceImpl();

        if(customerService.selectCustomer(name)==null) {

            CustomersEntity customers = new CustomersEntity();
            customers.setTelephone(telephone);
            customers.setName(name);
            customers.setRemark(remark);
            customers.setFax(fax);
            customers.setAddress(address);

            customerService.insertCustomer(customers);

            return true;
        }
        else {
            return false;
        }
    }
}
