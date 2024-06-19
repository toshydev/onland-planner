package onlandevents.com.backend.exception;

public class NoSuchLocationException extends RuntimeException {

        public NoSuchLocationException(String id) {
            super("Location with id " + id + " not found");
        }
}
