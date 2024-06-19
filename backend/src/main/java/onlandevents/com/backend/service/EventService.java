package onlandevents.com.backend.service;

import onlandevents.com.backend.dto.EventDTO;
import onlandevents.com.backend.exception.NoSuchEventException;
import onlandevents.com.backend.model.Event;
import onlandevents.com.backend.repo.EventRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    private final EventRepo eventRepo;

    public EventService(EventRepo eventRepo) {
        this.eventRepo = eventRepo;
    }

    public List<Event> getAllEvents() {
        return eventRepo.findAll();
    }

    public EventDTO getEventById(String id) {
        Event event = eventRepo.findById(id).orElseThrow(() -> new NoSuchEventException(id));
        return new EventDTO(event);
    }

    public EventDTO createEvent(EventDTO eventDTO) {
        Event event = new Event(eventDTO);
        eventRepo.save(event);
        return new EventDTO(event);
    }

    public EventDTO updateEvent(String id, EventDTO eventDTO) {
        Event event = eventRepo.findById(id).orElseThrow(() -> new NoSuchEventException(id));
        Event updatedEvent = new Event(eventDTO);
        updatedEvent.setId(event.getId());
        eventRepo.save(updatedEvent);
        return new EventDTO(updatedEvent);
    }

    public void deleteEvent(String id) {
        Event event = eventRepo.findById(id).orElseThrow(() -> new NoSuchEventException(id));
        eventRepo.delete(event);
    }

}
