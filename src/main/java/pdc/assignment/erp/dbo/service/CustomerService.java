package pdc.assignment.erp.dbo.service;

import pdc.assignment.erp.dbo.entity.CustomersEntity;

import java.util.List;

public interface CustomerService {

    public CustomersEntity selectCustomer(int cid);

    public CustomersEntity selectCustomer(String name);

    public List<CustomersEntity> selectCustomers();

    public List<CustomersEntity> selectCustomers(String name);

    public boolean updateCustomer(CustomersEntity customer);

    public boolean insertCustomer(CustomersEntity customer);

    public boolean deleteCustomer(CustomersEntity customer);
}
