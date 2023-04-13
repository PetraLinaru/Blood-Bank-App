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

    String encrypt(String password)
    {
        String encryptedPass= String.valueOf(StandardCharsets. UTF_8. encode(password));
        return encryptedPass;
    }
}
