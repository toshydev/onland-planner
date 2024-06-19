package onlandevents.com.backend.model;

import lombok.Data;
import onlandevents.com.backend.dto.LocationDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "events")
@Data
public class Location {

    @Id
    private String id;
    private String name;
    private String address;
    private String city;
    private String state;
    private String country;
    private String zipCode;
    private String description;
    private String imageUrl;

    public Location(LocationDTO locationDTO) {
        this.name = locationDTO.getName();
        this.address = locationDTO.getAddress();
        this.city = locationDTO.getCity();
        this.state = locationDTO.getState();
        this.country = locationDTO.getCountry();
        this.zipCode = locationDTO.getZipCode();
        this.description = locationDTO.getDescription();
        this.imageUrl = locationDTO.getImageUrl();
    }
}
