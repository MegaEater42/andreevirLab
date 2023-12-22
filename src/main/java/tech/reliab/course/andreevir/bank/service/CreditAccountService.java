package tech.reliab.course.andreevir.bank.service;

import tech.reliab.course.andreevir.bank.entity.CreditAccount;
import tech.reliab.course.andreevir.bank.exception.PaymentException;
import tech.reliab.course.andreevir.bank.exception.UniquenessException;

import java.util.List;

public interface CreditAccountService {
    CreditAccount create(CreditAccount creditAccount) throws UniquenessException;
    public CreditAccount getCreditAccountById(long id);
    public List<CreditAccount> getAllCreditAccounts();
    boolean makeMonthlyPayment(CreditAccount account) throws PaymentException;

}
