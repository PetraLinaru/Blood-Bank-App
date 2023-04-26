package BloodBank.controller;

import BloodBank.model.Location;
import BloodBank.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/location")
@CrossOrigin(origins="http://localhost:3000")
public class LocationController {

    private final LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Location>> findAll()
    {
        List<Location> locationList=locationService.getAllLocations();
        if(locationList!=null)
        {
            return ResponseEntity.ok(locationList);
        }
        else
            return (ResponseEntity<List<Location>>) ResponseEntity.internalServerError();
    }
}
