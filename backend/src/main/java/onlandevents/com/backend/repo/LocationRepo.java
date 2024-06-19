package onlandevents.com.backend.repo;

import onlandevents.com.backend.model.Location;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepo extends MongoRepository<Location, String>{
}
