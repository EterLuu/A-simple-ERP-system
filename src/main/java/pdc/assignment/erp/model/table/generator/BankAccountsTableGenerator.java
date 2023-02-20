package pdc.assignment.erp.model.table.generator;

import pdc.assignment.erp.dbo.service.BankaccountServiceImpl;
import pdc.assignment.erp.model.table.BankAccountsTableModel;
import pdc.assignment.erp.util.Judgement;

public class BankAccountsTableGenerator {

    private BankAccountsTableGenerator(){
        throw new IllegalStateException("Utility class");
    }

    private static BankaccountServiceImpl bankaccountService = new BankaccountServiceImpl();

    public static BankAccountsTableModel searchBankAccount(String name) {

        // Prevent SQL injection.
        if(!Judgement.judgeName(name)){
            return new BankAccountsTableModel(bankaccountService.selectBankAccounts());
        }

        return new BankAccountsTableModel(bankaccountService.selectBankAccounts(name));
    }

    public static BankAccountsTableModel searchBankAccount() {

        return new BankAccountsTableModel(bankaccountService.selectBankAccounts());
    }
}
