package facade;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import service.UserService;


public class UserFacadeImpl implements UserFacade {

    final UserService userService;

    @Autowired
    public UserFacadeImpl(UserService userService) {
        this.userService = userService;
    }


    @Override
    public User registerUser(User user) {
        return  userService.registerUser(user);
    }
}
