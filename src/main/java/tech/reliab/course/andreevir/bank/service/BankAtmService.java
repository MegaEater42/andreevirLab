package tech.reliab.course.andreevir.bank.service;

import tech.reliab.course.andreevir.bank.entity.BankAtm;

public interface BankAtmService {
    BankAtm create(BankAtm bankAtm);
    boolean depositMoney(BankAtm bankAtm, double amount);
    boolean withdrawMoney(BankAtm bankAtm, double amount);
}
