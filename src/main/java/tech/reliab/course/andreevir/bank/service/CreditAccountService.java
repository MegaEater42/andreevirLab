package tech.reliab.course.andreevir.bank.service;

import tech.reliab.course.andreevir.bank.entity.CreditAccount;

public interface CreditAccountService {
    CreditAccount create(CreditAccount creditAccount);
    boolean makeMonthlyPayment(CreditAccount account);
}
