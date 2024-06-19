package onlandevents.com.backend.repo;

import onlandevents.com.backend.model.Event;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepo extends MongoRepository<Event, String> {
}
