package tech.reliab.course.andreevir.bank.service;

import tech.reliab.course.andreevir.bank.entity.BankAtm;
import tech.reliab.course.andreevir.bank.entity.BankOffice;
import tech.reliab.course.andreevir.bank.entity.Employee;

public interface BankOfficeService {
    BankOffice create(BankOffice bankOffice);
    boolean installAtm(BankOffice bankOffice, BankAtm bankAtm);
    boolean removeAtm(BankOffice bankOffice, BankAtm bankAtm);
    boolean depositMoney(BankOffice bankOffice, double amount);
    boolean withdrawMoney(BankOffice bankOffice, double amount);
    boolean addEmployee(BankOffice bankOffice, Employee employee);
    boolean removeEmployee(BankOffice bankOffice, Employee employee);
}
