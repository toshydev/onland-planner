package onlandevents.com.backend.controller;

import onlandevents.com.backend.service.EventService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }
}
