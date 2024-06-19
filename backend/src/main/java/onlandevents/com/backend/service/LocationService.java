package onlandevents.com.backend.service;

import onlandevents.com.backend.dto.LocationDTO;
import onlandevents.com.backend.exception.NoSuchLocationException;
import onlandevents.com.backend.model.Location;
import onlandevents.com.backend.repo.LocationRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {

    private final LocationRepo locationRepo;

    public LocationService(LocationRepo locationRepo) {
        this.locationRepo = locationRepo;
    }

    public List<Location> getAllLocations() {
        return locationRepo.findAll();
    }

    public LocationDTO getLocationById(String id) {
        Location location = locationRepo.findById(id).orElseThrow(() -> new NoSuchLocationException(id));
        return new LocationDTO(location);
    }

    public LocationDTO createLocation(LocationDTO locationDTO) {
        Location location = new Location(locationDTO);
        locationRepo.save(location);
        return new LocationDTO(location);
    }


    public LocationDTO updateLocation(String id, LocationDTO locationDTO) {
        Location location = locationRepo.findById(id).orElseThrow(() -> new NoSuchLocationException(id));
        Location updatedLocation = new Location(locationDTO);
        updatedLocation.setId(location.getId());
        locationRepo.save(updatedLocation);
        return new LocationDTO(updatedLocation);
    }

    public void deleteLocation(String id) {
        Location location = locationRepo.findById(id).orElseThrow(() -> new NoSuchLocationException(id));
        locationRepo.delete(location);
    }

}
