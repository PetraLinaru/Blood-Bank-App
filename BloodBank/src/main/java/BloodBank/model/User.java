package BloodBank.model;

import jakarta.persistence.*;
import org.hibernate.mapping.Collection;

import java.awt.*;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="app_user")
@Inheritance(strategy = InheritanceType.JOINED)

public class User {
    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    public UUID uuid;

    public String email;
    public String password;
    public String name;
    public String role;



    public User(String email, String password, String name,String role ) {
        this.email = email;
        this.password = password;
        this.name=name;
        this.role=role;

    }

    public User() {

    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    String encrypt(String password)
    {
        String encryptedPass= String.valueOf(StandardCharsets. UTF_8. encode(password));
        return encryptedPass;
    }
}
