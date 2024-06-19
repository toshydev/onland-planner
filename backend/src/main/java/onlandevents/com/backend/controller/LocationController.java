package onlandevents.com.backend.controller;

import onlandevents.com.backend.service.LocationService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocationController {

    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }
}
