package model;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="USERS")
@Inheritance(strategy = InheritanceType.JOINED)
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name="user_ID",nullable = false)
    public String user_ID;


    @Column(name="username",nullable = false)
    private String username;

    @Column(name="password",nullable=false)
    private String password;

    @Column(name="firstname",nullable=false)
    public String firstName;

    @Column(name="lastname",nullable=false)
    public String lastName;

    @Column(name="email",nullable=false)
    private String email;

    @Column(name="phone",nullable=false)
    private String phone;

    public User( String user_ID,String username, String password, String firstName, String lastName, String email, String phone) {
        this.user_ID=user_ID;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    public User() {

    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUser_ID() {
        return user_ID;
    }

    public String getUsername()
    {
        return this.username;
    }
    public String getPassword()
    {
        return this.password;
    }

}
