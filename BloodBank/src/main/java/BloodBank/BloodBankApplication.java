package BloodBank;

import Repository.UserRepository;
import controller.UserController;
import facade.UserFacadeImpl;
import model.Role;
import model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import service.UserService;
import service.impl.UserServiceImpl;

@SpringBootApplication
public class BloodBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(BloodBankApplication.class, args);


	//	UserController userController=new UserController(userFacade);


		//userController.registerUser(new User("gigi@becali","1234","Marian","Marianul", Role.DONOR));
		//userController.registerUser(new User("seriozitate@yahoo.com","1234","Maria","Dreghine", Role.DOCTOR));
		}
	}


