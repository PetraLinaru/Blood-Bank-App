package controller;

import facade.UserFacade;
import model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserFacade userFacade;

    public UserController(UserFacade userFacade)
    {
        this.userFacade = userFacade;
    }


    @PostMapping("/user")
    public ResponseEntity<User> registerUser(@RequestBody User user)
    {
        User registeredUser=  userFacade.registerUser(user);
        return ResponseEntity.ok(registeredUser);
    }

}
