package tech.reliab.course.andreevir.bank.entity.common;

import tech.reliab.course.andreevir.bank.entity.Bank;
import tech.reliab.course.andreevir.bank.entity.User;

public class Account {
    private static int currentId = 0;
    protected int id;
    protected User user = null;
    protected Bank bank = null;

    private void initializeId() {
        id = currentId++;
    }

    public Account() {
        initializeId();
    }

    public Account(User user, Bank bank) {
        initializeId();
        this.user = user;
        this.bank = bank;
    }

    public Account(int id, User user, Bank bank) {
        this.id = id;
        this.user = user;
        this.bank = bank;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Bank getBank() {
        return bank;
    }
}
