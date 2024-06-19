package onlandevents.com.backend.util;

public enum EventStatus {

    DRAFT("Draft"),
    PUBLISHED("Published"),
    CANCELLED("Cancelled"),
    POSTPONED("Postponed"),
    COMPLETED("Completed");

    private final String status;

    EventStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public static EventStatus fromString(String status) {
        for (EventStatus eventStatus : EventStatus.values()) {
            if (eventStatus.status.equalsIgnoreCase(status)) {
                return eventStatus;
            }
        }
        return null;
    }
}
