package service;

import model.User;

public interface UserService {
    User registerUser(User newUser);
    User loginUser(String password, String email);
    User getUser(String verification);

//extras
    User findUserByEmail(String email);
    User findMaybeExistingUser(String firstName, String lastName, String email);

    User editUser(User oldUser);
}
