package tech.reliab.course.andreevir.bank.exception;

public class UniquenessException extends RuntimeException {
    public UniquenessException(String entity, long id) {
        super("Error: " + entity + " with id: " + id + " already exists.");
    }
}