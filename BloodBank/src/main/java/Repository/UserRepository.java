package Repository;

import model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {


    User findUserByEmail(String email);
    User findUserByEmailAndFirstNameAndLastName(String email,String firstName,String lastName);
    User findUserByEmailAndPassword(String email,String password);
}
