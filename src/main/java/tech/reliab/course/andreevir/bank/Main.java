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
import tech.reliab.course.andreevir.bank.util.Constants;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static tech.reliab.course.andreevir.bank.util.Constants.BANK_ROLES;
import static tech.reliab.course.andreevir.bank.util.Constants.COMPANY_NAMES;
import static tech.reliab.course.andreevir.bank.util.Constants.PERSON_NAMES;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        new Constants();
        Scanner scanner = new Scanner(System.in);

        // Создание сервисов
        BankService bankService = new BankServiceImpl();
        BankOfficeService bankOfficeService = new BankOfficeServiceImpl(bankService);
        bankService.setBankOfficeService(bankOfficeService);
        EmployeeService employeeService = new EmployeeServiceImpl(bankOfficeService);
        BankAtmService atmService = new BankAtmServiceImpl(bankOfficeService);
        UserService userService = new UserServiceImpl(bankService);
        bankService.setUserService(userService);
        PaymentAccountService paymentAccountService = new PaymentAccountServiceImpl(userService);
        CreditAccountService creditAccountService = new CreditAccountServiceImpl(userService);

        // Создание банков
        bankService.create(new Bank("Alpha Bank"));
        bankService.create(new Bank("Tinkoff Bank"));
        bankService.create(new Bank("Sberbank"));
        bankService.create(new Bank("Post Office Bank"));
        bankService.create(new Bank("Otkritie Bank"));
        // System.out.println(bank);

        // Создание офисов в каждом банке
        List<Bank> banks = bankService.getAllBanks();
        for (Bank bank : banks) {
            for (int i = 1; i <= 3; i++) {
                bankOfficeService.create(new BankOffice(
                        "Office #" + String.valueOf(i) + " of " + bank.getName(),
                        "Belgorod, Pushkina st., " + String.valueOf(i),
                        bank,
                        true,
                        true,
                        true,
                        true,
                        true,
                        10000,
                        100 * i
                ));
            }
        }

        // Добавление сотрудников в каждый офис
        List<BankOffice> offices = bankOfficeService.getAllOffices();
        for (BankOffice office : offices) {
            for (int i = 1; i <= 5; i++) {
                employeeService.create(new Employee(
                        PERSON_NAMES.get(random.nextInt(PERSON_NAMES.size())),
                        LocalDate.of(random.nextInt(1990, 2003), random.nextInt(1, 13), random.nextInt(1, 29)),
                        BANK_ROLES.get(random.nextInt(BANK_ROLES.size())),
                        office.getBank(),
                        true,
                        office,
                        true,
                        500
                ));
            }
        }

        // Добавление банкоматов в каждый офис
        for (BankOffice office : offices) {
            for (int i = 1; i <= 3; i++) {
                atmService.create(new BankAtm(
                        "ATM " + String.valueOf(i),
                        office.getAddress(),
                        BankAtmStatus.WORKING,
                        office.getBank(),
                        office,
                        bankOfficeService.getAllEmployeesByOfficeId(office.getId()).get(random.nextInt(bankOfficeService.getAllEmployeesByOfficeId(office.getId()).size())),
                        true,
                        true,
                        0,
                        random.nextDouble() * 25
                ));
            }
        }

        // Добавление клиентов в каждый банк
        for (Bank bank : banks) {
            for (int i = 1; i <= 5; i++) {
                userService.create(
                        new User(
                                PERSON_NAMES.get(random.nextInt(PERSON_NAMES.size())),
                                LocalDate.of(random.nextInt(1940, 2003), random.nextInt(1, 13), random.nextInt(1, 29)),
                                COMPANY_NAMES.get(random.nextInt(COMPANY_NAMES.size())),
                                random.nextDouble() * 10000,
                                bank,
                                random.nextInt(10000)
                        ));
            }
        }

        // Добавление платежных счетов каждому клиенту
        List<User> users = userService.getAllUsers();
        for (User user : users) {
            for (int i = 1; i <= 2; i++) {
                paymentAccountService.create(new PaymentAccount(
                        user,
                        user.getBank(),
                        random.nextDouble() * 10000
                ));
            }
        }

        // Добавление кредитных счетов каждому клиенту
        for (User user : users) {
            for (int i = 1; i <= 2; i++) {
                List<BankOffice> bankOffices = bankService.getAllOfficesByBankId(user.getBank().getId());
                BankOffice randomOffice = bankOffices.get(random.nextInt(bankOffices.size()));
                List<Employee> officeEmployees = bankOfficeService.getAllEmployeesByOfficeId(randomOffice.getId());
                Employee randomEmployee = officeEmployees.get(random.nextInt(officeEmployees.size()));

                creditAccountService.create(new CreditAccount(
                        user,
                        user.getBank(),
                        LocalDate.of(2023, 10, 1),
                        LocalDate.of(2026, 10, 1),
                        36,
                        3600,
                        3600,
                        100,
                        user.getBank().getInterestRate(),
                        randomEmployee,
                        userService.getAllPaymentAccountsByUserId(user.getId()).get(random.nextInt(userService.getAllPaymentAccountsByUserId(user.getId()).size()))
                ));
            }
        }

        System.out.println("Number of banks in system: " + bankService.getAllBanks().size());
        for (Bank bank : bankService.getAllBanks()) {
            System.out.println("id №" + bank.getId() + " - " + bank.getName());
        }

        while (true) {
            System.out.println("\nChoose an action: ");
            System.out.println("1) check bank data by bank id");
            System.out.println("2) check user data by user id");
            System.out.println("3) quit");

            String action = scanner.nextLine();

            if (action.equals("1")) {
                System.out.println("Enter bank id:");
                int bankIdToPrint = scanner.nextInt();
                scanner.nextLine();
                bankService.printBankData(bankIdToPrint);
            } else if (action.equals("2")) {
                System.out.println("Enter user id:");
                int userIdToPrint = scanner.nextInt();
                scanner.nextLine();
                userService.printUserData(userIdToPrint, true);
            } else if (action.equals("3")) {
                break;
            } else {
                System.out.println("Error: unknown action. Please, try again");
            }
        }
    }
}
