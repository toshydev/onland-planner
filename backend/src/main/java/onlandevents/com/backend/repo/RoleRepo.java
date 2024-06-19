package onlandevents.com.backend.repo;

import onlandevents.com.backend.model.ERole;
import onlandevents.com.backend.model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RoleRepo extends MongoRepository<Role, String> {
    Optional<Role> findByName(ERole name);
}
