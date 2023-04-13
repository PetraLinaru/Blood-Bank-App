package BloodBank.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="doctor")
public class Doctor extends User{
    public String specialization;

    public Doctor(String email, String password, String name, String role, String specialization) {
        super(email, password, name, role);
        this.specialization = specialization;
    }

    public Doctor() {

    }

    public String getSpecialization() {
        return this.specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public Doctor(String specialization) {
        this.specialization = specialization;

    }
}
