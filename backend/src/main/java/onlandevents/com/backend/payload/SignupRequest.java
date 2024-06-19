package onlandevents.com.backend.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignupRequest {

        @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters long")
        private String username;

        @NotBlank(message = "Email is required")
        // @Max(value = 50, message = "Email must be less than 50 characters long")
        @Email
        private String email;

        @NotBlank(message = "Password is required")
        @Min(value = 8, message = "Password must be at least 8 characters long")
        private String password;

        //private Set<String> roles;

        private String isModerator;

}
