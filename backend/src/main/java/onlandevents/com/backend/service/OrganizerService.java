package onlandevents.com.backend.service;

import onlandevents.com.backend.dto.OrganizerDTO;
import onlandevents.com.backend.exception.NoSuchOrganizerException;
import onlandevents.com.backend.model.Organizer;
import onlandevents.com.backend.model.User;
import onlandevents.com.backend.repo.OrganizerRepo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizerService {

    private final OrganizerRepo organizerRepo;

    private final UserService userService;

    public OrganizerService(OrganizerRepo organizerRepo, UserService userService) {
        this.organizerRepo = organizerRepo;
        this.userService = userService;
    }

    public List<Organizer> getAllOrganizers() {
        return organizerRepo.findAll();
    }

    public OrganizerDTO getOrganizerById(String id) {
        Organizer organizer = organizerRepo.findById(id).orElseThrow(() -> new NoSuchOrganizerException(id));
        return new OrganizerDTO(organizer);
    }

    public Organizer createOrganizer(OrganizerDTO organizerDTO) {
        String currentUserName = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.getUserByUsername(currentUserName);
        if (user == null) {
            throw new IllegalArgumentException("User " + currentUserName + " not found");
        }
        Organizer organizer = new Organizer(organizerDTO);
        if (organizer.getModeratorIds() == null) {
            organizer.setModeratorIds(List.of(user.getId()));
        } else {
            organizer.getModeratorIds().add(user.getId());
        }
        return organizerRepo.save(organizer);
    }

    public OrganizerDTO updateOrganizer(String id, OrganizerDTO organizerDTO) {
        Organizer organizer = organizerRepo.findById(id).orElseThrow(() -> new NoSuchOrganizerException(id));
        User user = userService.getUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        if (user == null || !organizer.getModeratorIds().contains(user.getId())) {
            assert user != null;
            throw new IllegalArgumentException("User " + user.getUsername() + " is not a moderator of organizer " + organizer.getName());
        }
        Organizer updatedOrganizer = new Organizer(organizerDTO);
        updatedOrganizer.setId(organizer.getId());
        organizerRepo.save(updatedOrganizer);
        return new OrganizerDTO(updatedOrganizer);
    }

    public void deleteOrganizer(String id) {
        Organizer organizer = organizerRepo.findById(id).orElseThrow(() -> new NoSuchOrganizerException(id));
        organizerRepo.delete(organizer);
    }

}
