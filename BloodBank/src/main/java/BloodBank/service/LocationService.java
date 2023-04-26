package BloodBank.service;

import BloodBank.model.Location;

import java.util.List;
import java.util.UUID;

public interface LocationService {
     List<Location> getAllLocations();
     Location getLocationByLocationid(UUID locationid);
}
