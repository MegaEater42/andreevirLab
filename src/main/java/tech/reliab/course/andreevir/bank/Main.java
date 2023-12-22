package tech.reliab.course.andreevir.bank;

import tech.reliab.course.andreevir.bank.entity.Bank;
import tech.reliab.course.andreevir.bank.entity.BankAtm;
import tech.reliab.course.andreevir.bank.entity.BankOffice;
import tech.reliab.course.andreevir.bank.entity.CreditAccount;
import tech.reliab.course.andreevir.bank.entity.Employee;
import tech.reliab.course.andreevir.bank.entity.PaymentAccount;
import tech.reliab.course.andreevir.bank.entity.User;
import tech.reliab.course.andreevir.bank.service.BankAtmService;
import tech.reliab.course.andreevir.bank.service.BankOfficeService;
import tech.reliab.course.andreevir.bank.service.BankService;
import tech.reliab.course.andreevir.bank.service.CreditAccountService;
import tech.reliab.course.andreevir.bank.service.EmployeeService;
import tech.reliab.course.andreevir.bank.service.PaymentAccountService;
import tech.reliab.course.andreevir.bank.service.UserService;
import tech.reliab.course.andreevir.bank.service.impl.BankAtmServiceImpl;
import tech.reliab.course.andreevir.bank.service.impl.BankOfficeServiceImpl;
import tech.reliab.course.andreevir.bank.service.impl.BankServiceImpl;
import tech.reliab.course.andreevir.bank.service.impl.CreditAccountServiceImpl;
import tech.reliab.course.andreevir.bank.service.impl.EmployeeServiceImpl;
import tech.reliab.course.andreevir.bank.service.impl.PaymentAccountServiceImpl;
import tech.reliab.course.andreevir.bank.service.impl.UserServiceImpl;
import tech.reliab.course.andreevir.bank.util.BankAtmStatus;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        BankService bankService = new BankServiceImpl();
        Bank bank = bankService.create(new Bank("Test Bank"));
        System.out.println(bank);

        BankOfficeService bankOfficeService = new BankOfficeServiceImpl();
        BankOffice bankOffice = bankOfficeService.create(new BankOffice(
                "Main office of the Test Bank",
                "Belgorod, Kostyukova Street, 46",
                bank,
                true,
                true,
                0,
                true,
                true,
                true,
                bank.getTotalMoney(),
                950
        ));
        System.out.println(bankOffice);

        EmployeeService employeeService = new EmployeeServiceImpl();
        Employee employee = employeeService.create(new Employee("Somebody", LocalDate.of(2003, 5, 19), "Boss", bank, true, bankOffice, true, 42));
        System.out.println(employee);

        BankAtmService bankAtmService = new BankAtmServiceImpl();
        BankAtm bankAtm = bankAtmService.create(new BankAtm("Atm №1", bankOffice.getAddress(), BankAtmStatus.WORKING, bank, bankOffice, employee, true, true, 0, 35));
        System.out.println(bankAtm);

        UserService userService = new UserServiceImpl();
        User user = userService.create(new User("Boba", LocalDate.of(2000, 3, 13), "Somewhere", 4500.0, bank, 8000));
        System.out.println(user);

        PaymentAccountService paymentAccountService = new PaymentAccountServiceImpl();
        PaymentAccount paymentAccount = paymentAccountService.create(new PaymentAccount(user, bank, 300));
        System.out.println(paymentAccount);

        CreditAccountService creditAccountService = new CreditAccountServiceImpl();
        CreditAccount creditAccount = creditAccountService.create(new CreditAccount(user, bank, LocalDate.of(2021, 5, 1), LocalDate.of(2025, 1, 1), 35, 3100, 3100, 75, 3, employee, paymentAccount));
        System.out.println(creditAccount);
    }
}
