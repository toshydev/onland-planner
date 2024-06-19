package onlandevents.com.backend.repo;

import onlandevents.com.backend.model.RefreshToken;
import onlandevents.com.backend.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RefreshTokenRepo extends MongoRepository<RefreshToken, String> {
    Optional<RefreshToken> findByToken(String token);

    void deleteAllByUser(User user);
}
