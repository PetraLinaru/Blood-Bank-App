package BloodBank.controller;

import BloodBank.facade.UserFacade;
import BloodBank.model.User;
import BloodBank.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService)
    {
        this.userService=userService;
    }


    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user)
    {
        User registeredUser = userService.registerUser(user);
        return ResponseEntity.ok(registeredUser);
    }

    @GetMapping("/find/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable("email")String email)
    {
        User registeredUser = userService.findUserByEmail(email);
        return ResponseEntity.ok(registeredUser);
    }




}
