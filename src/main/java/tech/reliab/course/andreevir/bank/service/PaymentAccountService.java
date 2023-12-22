package tech.reliab.course.andreevir.bank.service;

import tech.reliab.course.andreevir.bank.entity.PaymentAccount;

import java.util.List;

public interface PaymentAccountService {
    PaymentAccount create(PaymentAccount paymentAccount);
    public void printPaymentData(int id);
    public PaymentAccount getPaymentAccountById(int id);
    public List<PaymentAccount> getAllPaymentAccounts();
    boolean depositMoney(PaymentAccount account, double amount);
    boolean withdrawMoney(PaymentAccount account, double amount);
}
