package BloodBank.service;

import BloodBank.model.User;

import java.util.UUID;

public interface UserService {
    User registerUser(User newUser);
    User loginUser(String password, String email);
    User getUser(String verification);

//extras
    User findUserByEmail(String email);
    User findUserByEmailAndPassword(String email,String password);
    User findMaybeExistingUser(String firstName, String lastName, String email);
    User editUser(User oldUser);
    void deleteUser(User found);
    public User findUserByUuid(UUID uuid);
}
