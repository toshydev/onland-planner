package onlandevents.com.backend.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import onlandevents.com.backend.model.Location;

@Data
public class LocationDTO {

    @NotBlank(message = "Name is required")
    @Min(value = 3, message = "Name should have at least 3 characters")
    private String name;

    @NotBlank(message = "Address is required")
    private String address;

    @NotBlank(message = "City is required")
    private String city;

    private String state;

    @NotBlank(message = "Country is required")
    private String country;

    @NotBlank(message = "Zip code is required")
    private String zipCode;

    @NotBlank(message = "Description is required")
    private String description;

    private String imageUrl;

    public LocationDTO(Location location) {
        this.name = location.getName();
        this.address = location.getAddress();
        this.city = location.getCity();
        this.state = location.getState();
        this.country = location.getCountry();
        this.zipCode = location.getZipCode();
        this.description = location.getDescription();
        this.imageUrl = location.getImageUrl();
    }

}
