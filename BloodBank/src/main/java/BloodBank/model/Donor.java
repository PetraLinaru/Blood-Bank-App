package BloodBank.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name="donor")
@PrimaryKeyJoinColumn(name="uuid")
public class Donor extends User{

    public String blood_type;

    public Donor(String email, String password, String name, String role, String bloodType) {
        super(email, password, name, role);
        this.blood_type = bloodType;
    }

    public Donor(String bloodType) {
        this.blood_type = bloodType;
    }

    public Donor() {

    }


}
