package BloodBank.Repository;

import BloodBank.model.Doctor;
import BloodBank.model.Donor;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
@Transactional
public interface DonorRepository extends JpaRepository<Donor, UUID> {
    Donor findDonorByEmail(String email);
    //    User findUserByEmailAndFirstNameAndLastName(String email,String firstName,String lastName);
    Donor findDonorByEmailAndPassword(String email,String password);
    Donor findDonorByUuid(UUID uuid);
    @Modifying
    @Query("Update Donor d set d.name = :name, d.email = :email, d.password = :password, d.blood_type = :blood_type where d.uuid = :uuid" )
    void updateDonor(@Param("name")String name, @Param("email") String email, @Param("password") String password, @Param("blood_type") String blood_type, @Param("uuid") UUID uuid);
}
