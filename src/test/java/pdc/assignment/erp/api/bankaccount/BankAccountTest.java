package pdc.assignment.erp.api.bankaccount;

import org.junit.jupiter.api.Test;
import pdc.assignment.erp.dbo.service.BankaccountServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Test
    void addAccount() {
        BankaccountServiceImpl bankaccountService = new BankaccountServiceImpl();

        assertTrue(BankAccountAdd.addAccount("ABC", "23456788986"));
        assertTrue(BankAccountAdd.addAccount("Klay","werwersuwer"));
        assertTrue(BankAccountAdd.addAccount("Stephen","124huihi323"));
        assertTrue(BankAccountAdd.addAccount("jordan","wer98976sdf"));
        assertTrue(BankAccountAdd.addAccount("james","000dfd"));

        assertTrue(BankAccountDelete.deleteAccount(bankaccountService.selectBankAccount("ABC").getBid()));
        assertTrue(BankAccountDelete.deleteAccount(bankaccountService.selectBankAccount("Klay").getBid()));
        assertTrue(BankAccountDelete.deleteAccount(bankaccountService.selectBankAccount("Stephen").getBid()));
        assertTrue(BankAccountDelete.deleteAccount(bankaccountService.selectBankAccount("jordan").getBid()));
        assertTrue(BankAccountDelete.deleteAccount(bankaccountService.selectBankAccount("james").getBid()));

        assertFalse(BankAccountAdd.addAccount("#^", "4654564564564"));
        assertFalse(BankAccountAdd.addAccount("jjking","#%$^&%"));
        assertFalse(BankAccountAdd.addAccount("","24324355ds"));
        assertFalse(BankAccountAdd.addAccount("theshy",""));
        assertFalse(BankAccountAdd.addAccount("rookie","404kljdfdsfkdsjfakjsdfkjdsklfjlsdjfklsjdflksdjfksjfswee"));
    }
}