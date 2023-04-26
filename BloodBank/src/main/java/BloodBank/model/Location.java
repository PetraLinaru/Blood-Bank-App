package BloodBank.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name="location")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public UUID locationid;

    public String location_name;
    public String city;
    public String region;

    public Location(UUID id, String location_name, String city, String region) {
        this.locationid = id;
        this.location_name = location_name;
        this.city=city;
        this.region=region;
    }

    public Location() {

    }

    public UUID getLocationId() {
        return this.locationid;
    }

    public void setLocationId(UUID location_id) {
        this.locationid = location_id;
    }

    public String getLocation_name() {
        return location_name;
    }

    public void setLocation_name(String location_name) {
        this.location_name = location_name;
    }
}
