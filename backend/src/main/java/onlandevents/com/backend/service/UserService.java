package onlandevents.com.backend.service;

import onlandevents.com.backend.model.User;
import onlandevents.com.backend.repo.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User getUserByUsername(String username) {
        return userRepo.findByUsername(username).orElse(null);
    }

}
