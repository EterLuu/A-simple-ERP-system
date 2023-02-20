package pdc.assignment.erp.api.bankaccount;

import pdc.assignment.erp.dbo.entity.BankAccountsEntity;
import pdc.assignment.erp.dbo.service.BankaccountServiceImpl;

public class BankAccountDelete {

    private BankAccountDelete(){
        throw new IllegalStateException("Utility class");
    }

    public static boolean deleteAccount(int bid){

        BankaccountServiceImpl bankaccountService = new BankaccountServiceImpl();

        BankAccountsEntity bankAccount = bankaccountService.selectBankAccount(bid);

        if (bankAccount == null)
            return false;

        return bankaccountService.deleteBankAccount(bankAccount);
    }
}
