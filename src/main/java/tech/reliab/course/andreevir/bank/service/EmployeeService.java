package tech.reliab.course.andreevir.bank.service;

import tech.reliab.course.andreevir.bank.entity.BankOffice;
import tech.reliab.course.andreevir.bank.entity.Employee;

public interface EmployeeService {
    Employee create(Employee employee);
    boolean transferEmployee(Employee employee, BankOffice bankOffice);
}
