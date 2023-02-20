package pdc.assignment.erp.api.customer;

import pdc.assignment.erp.dbo.entity.CustomersEntity;
import pdc.assignment.erp.dbo.service.CustomerServiceImpl;
import pdc.assignment.erp.util.Judgement;

public class CustomerUpdate {

    private CustomerUpdate(){
        throw new IllegalStateException("Utility class");
    }
    public static boolean customerUpdate(int cid, String name, String address, String telephone, String fax, String remark) {

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

        CustomersEntity customer = customerService.selectCustomer(cid);

        if(customer == null)
            return false;
        
        if (customer.getName().equals(name)){
            CustomersEntity temp = customerService.selectCustomer(name);
            if(temp!=null){
                if(temp.getCid()!=cid){
                    return false;
                }
            }
            else{
                customer.setName(name);
            }
        }
        else {
            customer.setName(name);
        }

        customer.setAddress(address);
        customer.setFax(fax);
        customer.setRemark(remark);
        customer.setTelephone(telephone);

        customerService.updateCustomer(customer);

        return true;
    }
}
