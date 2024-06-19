package onlandevents.com.backend.exception;

public class NoSuchOrganizerException extends RuntimeException {

        public NoSuchOrganizerException(String id) {
            super("Organizer with id " + id + " not found");
        }
}
