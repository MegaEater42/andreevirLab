package tech.reliab.course.andreevir.bank.service;

import tech.reliab.course.andreevir.bank.entity.BankOffice;
import tech.reliab.course.andreevir.bank.entity.Employee;
import tech.reliab.course.andreevir.bank.exception.UniquenessException;

import java.util.List;

public interface EmployeeService {
    Employee create(Employee employee) throws UniquenessException;
    public Employee getEmployeeById(long id);
    public List<Employee> getAllEmployees();
    public boolean isEmployeeSuitable(Employee employee);
}
