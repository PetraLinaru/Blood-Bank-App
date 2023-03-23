package model;

import jakarta.persistence.*;

import java.util.UUID;
@Entity
@Table(name="DOCTOR")
@PrimaryKeyJoinColumn(name="doctor_ID")
public class Doctor extends User{
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

    public Doctor(String doctor_ID, String username, String password, String firstName, String lastName, String email, String phone) {
        super(doctor_ID,username, password, firstName, lastName, email, phone);
    }

    public Doctor() {
        super();
    }

}
