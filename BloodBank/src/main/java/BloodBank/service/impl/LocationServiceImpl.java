package BloodBank.service.impl;

import BloodBank.Repository.LocationRepository;
import BloodBank.model.Location;
import BloodBank.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LocationServiceImpl implements LocationService {
    final LocationRepository locationRepository;

    @Autowired
    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public List<Location> getAllLocations()
    {
        List<Location> locations=locationRepository.findAll();
        return locations;
    }

    public Location getLocationByLocationid(UUID locationid)
    {
       Location found= locationRepository.findLocationByLocationid(locationid);
       return found;

    }


}
