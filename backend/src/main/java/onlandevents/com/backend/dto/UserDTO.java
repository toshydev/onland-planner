package onlandevents.com.backend.dto;

import lombok.Data;
import onlandevents.com.backend.model.User;

@Data
public class UserDTO {

    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private boolean enabled;
    private long created;
    private long lastAuthentication;
    private long lastPasswordChange;
    private long lastPasswordReset;
    private long lastFailedLogin;
    private int failedLoginAttempts;
    private boolean emailVerified;
    private String provider;
    private String providerId;

    public UserDTO(User user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.email = user.getEmail();
    }

}
