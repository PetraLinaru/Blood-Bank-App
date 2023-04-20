package BloodBank.Repository;

import BloodBank.model.Doctor;
import BloodBank.model.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@Transactional
public interface DoctorRepository extends JpaRepository<Doctor, UUID> {
    Doctor findDoctorByEmail(String email);
    //    User findUserByEmailAndFirstNameAndLastName(String email,String firstName,String lastName);
    Doctor findDoctorByEmailAndPassword(String email,String password);
    Doctor findDoctorByUuid(UUID uuid);
    @Modifying
    @Query("Update Doctor d set d.name = :name, d.email = :email, d.password = :password, d.specialization = :specialization where d.uuid = :uuid" )
    void updateDoctor(@Param("name")String name, @Param("email") String email, @Param("password") String password, @Param("specialization") String specialization,@Param("uuid") UUID uuid);
}
