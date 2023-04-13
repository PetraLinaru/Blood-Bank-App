package BloodBank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class BloodBankApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder){
		return applicationBuilder.sources(BloodBankApplication.class);
	}
	public static void main(String[] args) throws Exception{
		SpringApplication.run(BloodBankApplication.class, args);


	//	UserController userController=new UserController(userFacade);


		//userController.registerUser(new User("gigi@becali","1234","Marian","Marianul", Role.DONOR));
		//userController.registerUser(new User("seriozitate@yahoo.com","1234","Maria","Dreghine", Role.DOCTOR));
		}
	}


