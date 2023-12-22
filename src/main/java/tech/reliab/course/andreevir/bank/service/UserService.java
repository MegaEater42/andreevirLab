package tech.reliab.course.andreevir.bank.service;

import tech.reliab.course.andreevir.bank.entity.CreditAccount;
import tech.reliab.course.andreevir.bank.entity.PaymentAccount;
import tech.reliab.course.andreevir.bank.entity.User;
import tech.reliab.course.andreevir.bank.exception.NoPaymentAccountException;
import tech.reliab.course.andreevir.bank.exception.NotFoundException;
import tech.reliab.course.andreevir.bank.exception.UniquenessException;

import java.util.List;

public interface UserService {
    User create(User user) throws UniquenessException;
    public void printUserData(long id, boolean withAccounts);
    public User getUserById(long id);
    public List<User> getAllUsers();
    public boolean addPaymentAccount(long userId, PaymentAccount paymentAccount);
    public boolean addCreditAccount(long userId, CreditAccount creditAccount);
    public List<PaymentAccount> getAllPaymentAccountsByUserId(long userId);
    public int calculateCreditRating(User user);
    public PaymentAccount getBestPaymentAccount(long id) throws NotFoundException, NoPaymentAccountException;
}
