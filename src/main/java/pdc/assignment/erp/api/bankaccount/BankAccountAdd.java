package pdc.assignment.erp.api.bankaccount;

import pdc.assignment.erp.dbo.entity.BankAccountsEntity;
import pdc.assignment.erp.dbo.service.BankaccountServiceImpl;
import pdc.assignment.erp.util.Judgement;

public class BankAccountAdd {

    private BankAccountAdd(){
        throw new IllegalStateException("Utility class");
    }

    public static boolean addAccount(String name, String card){

        // Prevent SQL injection.
        if(!(Judgement.judgeName(name))){
            return false;
        }
        if(!(Judgement.judgeStringWithoutEmpty(card))){
            return false;
        }

        BankaccountServiceImpl bankaccountService = new BankaccountServiceImpl();

        if(bankaccountService.selectBankAccount(name)==null) {

            BankAccountsEntity bankAccount = new BankAccountsEntity();
            bankAccount.setCard(card);
            bankAccount.setName(name);

            bankaccountService.insertBankAccount(bankAccount);

            return true;
        }
        else {
            return false;
        }
    }
}
