package tech.reliab.course.andreevir.bank.service;

import tech.reliab.course.andreevir.bank.entity.BankAtm;
import tech.reliab.course.andreevir.bank.exception.UniquenessException;

import java.util.List;

public interface BankAtmService {
    BankAtm create(BankAtm bankAtm) throws UniquenessException;

    public BankAtm getBankAtmById(long id);

    public List<BankAtm> getAllBankAtms();

    boolean depositMoney(BankAtm bankAtm, double amount);

    boolean withdrawMoney(BankAtm bankAtm, double amount);

    public boolean isAtmSuitable(BankAtm bankAtm, double sum);
}