package onlandevents.com.backend.model;

import lombok.Data;
import onlandevents.com.backend.dto.EventDTO;
import onlandevents.com.backend.util.EventStatus;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "events")
@Data
public class Event {

    @Id
    private String id;
    private String name;
    private String description;
    private String imageUrl;
    private long startDateTime;
    private long endDateTime;
    private String category;
    private List<String> tags;
    private EventStatus status;
    private String organizerId;
    private String locationId;
    private List<String> actors;

    public Event(EventDTO eventDTO) {
        this.name = eventDTO.getName();
        this.description = eventDTO.getDescription();
        this.imageUrl = eventDTO.getImageUrl();
        this.startDateTime = eventDTO.getStartDateTime();
        this.endDateTime = eventDTO.getEndDateTime();
        this.category = eventDTO.getCategory();
        this.tags = eventDTO.getTags();
        this.status = eventDTO.getStatus();
        this.organizerId = eventDTO.getOrganizerId();
        this.locationId = eventDTO.getLocationId();
        this.actors = eventDTO.getActors();
    }

}
