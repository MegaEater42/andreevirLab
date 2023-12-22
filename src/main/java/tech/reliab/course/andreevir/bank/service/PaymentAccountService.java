package tech.reliab.course.andreevir.bank.service;

import tech.reliab.course.andreevir.bank.entity.PaymentAccount;
import tech.reliab.course.andreevir.bank.exception.AccountTransferException;
import tech.reliab.course.andreevir.bank.exception.UniquenessException;

import java.util.List;

public interface PaymentAccountService {
    PaymentAccount create(PaymentAccount paymentAccount) throws UniquenessException;
    public void printPaymentData(long id);
    public PaymentAccount getPaymentAccountById(long id);
    public List<PaymentAccount> getAllPaymentAccounts();
    boolean depositMoney(PaymentAccount account, double amount);
    boolean withdrawMoney(PaymentAccount account, double amount);
    public boolean importAccountsFromTxtAndTransferToAnotherBank(String fileName, long newBankId) throws AccountTransferException;
    public void setCreditAccountService(CreditAccountService creditAccountService);
    public void setBankService(BankService bankService);
}
