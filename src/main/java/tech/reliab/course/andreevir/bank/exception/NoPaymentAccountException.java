package tech.reliab.course.andreevir.bank.exception;

public class NoPaymentAccountException extends RuntimeException {
    public NoPaymentAccountException() {
        super("Error: no payment accounts found.");
    }
}