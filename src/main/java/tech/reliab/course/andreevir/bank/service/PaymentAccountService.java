package tech.reliab.course.andreevir.bank.service;

import tech.reliab.course.andreevir.bank.entity.PaymentAccount;

public interface PaymentAccountService {
    PaymentAccount create(PaymentAccount paymentAccount);
    boolean depositMoney(PaymentAccount account, double amount);
    boolean withdrawMoney(PaymentAccount account, double amount);
}
