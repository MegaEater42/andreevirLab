package tech.reliab.course.andreevir.bank.exception;

public class CreditException extends RuntimeException {
    public CreditException(String msg) {
        super("Error: credit can't be approved - " + msg);
    }
}