package onlandevents.com.backend.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
public class UserInfoResponse {

    @Setter
    private String id;

    @Setter
    private String username;

    @Setter
    private String email;

    private List<String> roles;

}
