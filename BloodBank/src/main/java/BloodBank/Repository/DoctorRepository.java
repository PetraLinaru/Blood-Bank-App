package BloodBank.Repository;

import BloodBank.model.Doctor;
import BloodBank.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DoctorRepository extends JpaRepository<Doctor, UUID> {
    Doctor findDoctorByEmail(String email);
    //    User findUserByEmailAndFirstNameAndLastName(String email,String firstName,String lastName);
    Doctor findDoctorByEmailAndPassword(String email,String password);
}
