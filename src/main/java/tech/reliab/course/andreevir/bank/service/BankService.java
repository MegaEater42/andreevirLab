package tech.reliab.course.andreevir.bank.service;

import tech.reliab.course.andreevir.bank.entity.Bank;
import tech.reliab.course.andreevir.bank.entity.BankOffice;
import tech.reliab.course.andreevir.bank.entity.CreditAccount;
import tech.reliab.course.andreevir.bank.entity.Employee;
import tech.reliab.course.andreevir.bank.entity.User;

public interface BankService {
    Bank create(Bank bank);
    boolean addOffice(Bank bank, BankOffice bankOffice);
    boolean removeOffice(Bank bank, BankOffice bankOffice);
    boolean addEmployee(Bank bank, Employee employee);
    boolean removeEmployee(Bank bank, Employee employee);
    boolean addClient(Bank bank, User user);
    boolean removeClient(Bank bank, User user);
    double calculateInterestRate(Bank bank);
    boolean depositMoney(Bank bank, double amount);
    boolean withdrawMoney(Bank bank, double amount);
    boolean approveCredit(Bank bank, CreditAccount account, Employee employee);
}
