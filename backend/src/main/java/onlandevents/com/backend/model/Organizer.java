package onlandevents.com.backend.model;

import lombok.Data;
import onlandevents.com.backend.dto.OrganizerDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "organizers")
@Data
public class Organizer {

    @Id
    private String id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String city;
    private String state;
    private String country;
    private String zipCode;
    private String description;
    private String imageUrl;
    private List<String> moderatorIds;

    public Organizer(OrganizerDTO organizerDTO) {
        this.name = organizerDTO.getName();
        this.email = organizerDTO.getEmail();
        this.phone = organizerDTO.getPhone();
        this.address = organizerDTO.getAddress();
        this.city = organizerDTO.getCity();
        this.state = organizerDTO.getState();
        this.country = organizerDTO.getCountry();
        this.zipCode = organizerDTO.getZipCode();
        this.description = organizerDTO.getDescription();
        this.imageUrl = organizerDTO.getImageUrl();
    }

}
