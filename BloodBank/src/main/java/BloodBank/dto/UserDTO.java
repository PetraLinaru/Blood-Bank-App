package BloodBank.dto;

import BloodBank.model.Role;

import java.util.UUID;
//LA DTO PAUZA
// momentan
public class UserDTO {
    public UUID uuid;
    public String firstName;
    public String lastName;
    public Role role;

    public UserDTO(UUID uuid, String firstName, String lastName, Role role) {
        this.uuid = uuid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;

    }

    public UUID getUuid() {
        return uuid;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Role getRole() {
        return role;
    }
}
