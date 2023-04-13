package BloodBank.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="donor")
public class Donor extends User{
    private BloodType bloodType;

    public Donor(String email, String password, String name, String role, BloodType bloodType) {
        super(email, password, name, role);
        this.bloodType = bloodType;
    }

    public Donor(BloodType bloodType) {
        this.bloodType = bloodType;
    }

    public Donor() {

    }
}
