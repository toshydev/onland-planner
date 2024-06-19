package onlandevents.com.backend.repo;

import onlandevents.com.backend.model.Organizer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizerRepo extends MongoRepository<Organizer, String> {
}
