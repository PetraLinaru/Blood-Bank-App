package BloodBank.controller;

import BloodBank.model.User;
import BloodBank.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins="http://localhost:3000")
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
        System.out.println(email);
        User registeredUser = userService.findUserByEmail(email);
        System.out.println(registeredUser.email);
        return ResponseEntity.ok(registeredUser);

    }

    @PostMapping("/login")
    public ResponseEntity<User> loginUser(@RequestBody User user)
    {
        User found=userService.findUserByEmailAndPassword(user.email,user.password);
        if(user.password.equals(found.password))
        {
            return ResponseEntity.ok(found);
        }
        else
            return null;
    }


    @PostMapping("/deleteUser/{email}")
    public void deleteUser(@PathVariable("email")String email)
    {
        User found = userService.findUserByEmail(email);
        System.out.println(found.email);
        System.out.println("aici ba!");
        if (found!=null)
        {
            userService.deleteUser(found);
            System.out.println("aici");
        }
    }

    @GetMapping("/findUUID/{uuid}")
    public ResponseEntity<User> findUserByUUID(@PathVariable("uuid") UUID uuid)
    {
        User found=userService.findUserByUuid(uuid);
        if(found!=null)
        {
            return ResponseEntity.ok(found);
        }
        else
            return (ResponseEntity<User>) ResponseEntity.internalServerError();

    }





}
