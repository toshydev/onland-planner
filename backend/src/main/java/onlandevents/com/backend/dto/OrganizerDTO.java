package onlandevents.com.backend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import onlandevents.com.backend.model.Organizer;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrganizerDTO {

    @NotBlank(message = "Organizer name is required")
    @Min(value = 3, message = "Organizer name must be at least 3 characters long")
    private String name;

    @NotBlank(message = "Organizer email is required")
    @Email(message = "Organizer email must be a valid email address")
    private String email;

    private String phone;

    @NotBlank(message = "Organizer address is required")
    private String address;

    @NotBlank(message = "Organizer city is required")
    private String city;

    private String state;

    @NotBlank(message = "Organizer country is required")
    private String country;

    @NotBlank(message = "Organizer zip code is required")
    private String zipCode;

    @NotBlank(message = "Organizer description is required")
    @Min(value = 10, message = "Organizer description must be at least 10 characters long")
    private String description;

    private String imageUrl;

    public OrganizerDTO(Organizer organizer) {
        this.name = organizer.getName();
        this.email = organizer.getEmail();
        this.phone = organizer.getPhone();
        this.address = organizer.getAddress();
        this.city = organizer.getCity();
        this.state = organizer.getState();
        this.country = organizer.getCountry();
        this.zipCode = organizer.getZipCode();
        this.description = organizer.getDescription();
        this.imageUrl = organizer.getImageUrl();
    }

}
