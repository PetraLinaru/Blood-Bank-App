package BloodBank.Repository;

import BloodBank.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {


    User findUserByEmail(String email);
//    User findUserByEmailAndFirstNameAndLastName(String email,String firstName,String lastName);
    User findUserByEmailAndPassword(String email,String password);
}
