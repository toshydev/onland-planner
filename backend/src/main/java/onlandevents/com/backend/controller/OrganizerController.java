package onlandevents.com.backend.controller;

import lombok.extern.slf4j.Slf4j;
import onlandevents.com.backend.dto.OrganizerDTO;
import onlandevents.com.backend.model.Organizer;
import onlandevents.com.backend.service.OrganizerService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/organizer")
@Slf4j
public class OrganizerController {

    private final OrganizerService organizerService;

    public OrganizerController(OrganizerService organizerService) {
        this.organizerService = organizerService;
    }

    @PostMapping("/create")
    @PreAuthorize("hasRole('MODERATOR')")
    public Organizer createOrganizer(@RequestBody OrganizerDTO organizerDTO) {
        log.info("Creating organizer: {}", organizerDTO);
        return organizerService.createOrganizer(organizerDTO);
    }

    @PostMapping("/update/{id}")
    @PreAuthorize("hasRole('MODERATOR')")
    public OrganizerDTO updateOrganizer(@PathVariable String id, @RequestBody OrganizerDTO organizerDTO) {
        log.info("Updating organizer: {}", organizerDTO);
        return organizerService.updateOrganizer(id, organizerDTO);
    }

}
