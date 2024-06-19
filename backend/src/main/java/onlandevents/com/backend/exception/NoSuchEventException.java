package onlandevents.com.backend.exception;

public class NoSuchEventException extends RuntimeException {

    public NoSuchEventException(String id) {
        super("Event with id " + id + " not found");
    }
}
