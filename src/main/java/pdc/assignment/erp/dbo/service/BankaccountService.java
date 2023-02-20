package pdc.assignment.erp.dbo.service;

import pdc.assignment.erp.dbo.entity.BankAccountsEntity;

import java.util.List;

public interface BankaccountService {

    public BankAccountsEntity selectBankAccount(int bid);

    public BankAccountsEntity selectBankAccount(String name);

    public List<BankAccountsEntity> selectBankAccounts();

    public List<BankAccountsEntity> selectBankAccounts(String name);

    public boolean updateBankAccount(BankAccountsEntity entity);

    public boolean insertBankAccount(BankAccountsEntity entity);

    public boolean deleteBankAccount(BankAccountsEntity entity);
}
