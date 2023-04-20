package BloodBank.Repository;

import BloodBank.model.Doctor;
import BloodBank.model.Donor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface DonorRepository extends JpaRepository<Donor, UUID> {
    Donor findDonorByEmail(String email);
    //    User findUserByEmailAndFirstNameAndLastName(String email,String firstName,String lastName);
    Donor findDonorByEmailAndPassword(String email,String password);
    Donor findDonorByUuid(UUID uuid);
}
