package tech.reliab.course.andreevir.bank.exception;

public class AccountTransferException extends RuntimeException {
    public AccountTransferException(String msg) {
        super("Error: account transfer is not possible: " + msg);
    }
}
