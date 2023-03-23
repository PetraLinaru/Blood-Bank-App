package model;


import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name="DONOR")
@PrimaryKeyJoinColumn(name="donor_ID")
public class Donor extends User {
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

    public Donor(String donor_ID,String username, String password, String firstName, String lastName, String email, String phone) {
        super(donor_ID, username, password, firstName, lastName, email, phone);
    }

    public Donor() {
        super();
    }


}
