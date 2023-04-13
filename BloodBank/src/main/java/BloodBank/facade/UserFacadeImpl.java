package BloodBank.facade;

import BloodBank.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import BloodBank.service.UserService;


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

    public User getUserByEmail(String email){return userService.findUserByEmail(email);}
}
