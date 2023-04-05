package model;

import jakarta.persistence.*;
import org.hibernate.mapping.Collection;

import java.awt.*;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="User")
public class User {
    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    public UUID uuid;

    public String email;
    public String password;
    public String firstName;
    public String lastName;
    private boolean enabled;
    private boolean tokenExpired;
    private Role role;

    public User(String email, String password, String firstName, String lastName, Role role) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }

    String encrypt(String password)
    {
        String encryptedPass= String.valueOf(StandardCharsets. UTF_8. encode(password));
        return encryptedPass;
    }
}
