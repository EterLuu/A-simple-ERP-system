package pdc.assignment.erp.api.bankaccount;

import pdc.assignment.erp.dbo.entity.BankAccountsEntity;
import pdc.assignment.erp.dbo.service.BankaccountServiceImpl;
import pdc.assignment.erp.util.Judgement;

public class BankAccountUpdate {

    private BankAccountUpdate(){
        throw new IllegalStateException("Utility class");
    }

    public static boolean bankAccountUpdate(int bid, String name, String card) {

        // Prevent SQL injection.
        if(!(Judgement.judgeName(name))){
            return false;
        }
        if(!(Judgement.judgeStringWithoutEmpty(card))){
            return false;
        }

        BankaccountServiceImpl bankaccountService = new BankaccountServiceImpl();

        BankAccountsEntity bankAccount = bankaccountService.selectBankAccount(bid);

        if(bankAccount == null)
            return false;

        if (bankAccount.getName().equals(name)){
            BankAccountsEntity temp = bankaccountService.selectBankAccount(name);
            if(temp!=null){
                if(temp.getBid()!=bid){
                    return false;
                }
            }
            else{
                bankAccount.setName(name);
            }
        }
        else {
            bankAccount.setName(name);
        }

        bankAccount.setCard(card);

        bankaccountService.updateBankAccount(bankAccount);

        return true;
    }
}
