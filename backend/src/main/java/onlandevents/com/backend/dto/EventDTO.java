package onlandevents.com.backend.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import onlandevents.com.backend.model.Event;
import onlandevents.com.backend.util.EventStatus;

import java.util.List;

@Data
public class EventDTO {

    @NotBlank(message = "Name is required")
    @Min(value = 3, message = "Name should have at least 3 characters")
    private String name;

    @NotBlank(message = "Description is required")
    private String description;

    private String imageUrl;

    @NotNull(message = "Start date is required")
    @Future(message = "Start date must be in the future")
    private long startDateTime;

    @NotNull(message = "End date is required")
    @NotBlank(message = "End date is required")
    private long endDateTime;

    @NotBlank(message = "Category is required")
    private String category;

    private List<String> tags;

    @NotNull(message = "Status is required")
    private EventStatus status;

    @NotBlank(message = "Organizer ID is required")
    private String organizerId;

    @NotBlank(message = "Location ID is required")
    private String locationId;

    private List<String> actors;

    public EventDTO(Event event) {
        this.name = event.getName();
        this.description = event.getDescription();
        this.imageUrl = event.getImageUrl();
        this.startDateTime = event.getStartDateTime();
        this.endDateTime = event.getEndDateTime();
        this.category = event.getCategory();
        this.tags = event.getTags();
        this.status = event.getStatus();
        this.organizerId = event.getOrganizerId();
        this.locationId = event.getLocationId();
        this.actors = event.getActors();
    }
}
