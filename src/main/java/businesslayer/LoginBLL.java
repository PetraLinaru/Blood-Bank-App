package businesslayer;

import dao.UserDAO;
import hibernatestuff.HibernateUtils;
import model.User;
import org.hibernate.SessionFactory;
//clasa pe care am mesterit-o ca sa pot accesa current user si sa am si rolul, ca sa pot face diferite actiuni
//in rolesbll verific clasa userului si trimit mai departe si am un current user
//in loginbll iau current user si ma gandeam aici sa fac logica (if admin create account)/(if doctor ...)/(if donor)
//Ce ar trebui sa fac aici sa pot face functionalitatile descrise pt notele 7-8-9?/Ce ar trebui sa modific ca sa fie
//o structura decenta , acceptabila?

public class LoginBLL {
    RolesBLL rolesBLL;
    static User currentUser;
    private SessionFactory sessionFactory;
    private static LoginBLL loginBLL;
    public LoginBLL() {
    rolesBLL=new RolesBLL();

    }

    public void loginUser(String username,String password)
    {
        rolesBLL.setCurrentUser( username, password);
 //       rolesBLL.setCurrentRole();
        currentUser=rolesBLL.getCurrentUser();




    }
    public void signInUser(String username,String password,String firstName,String lastName,String phone,String email)
    {
        rolesBLL.signInUser(username,  password, firstName,lastName,phone,email);
 //       rolesBLL.setCurrentRole();
        currentUser=rolesBLL.getCurrentUser();



    }





}
