package businesslayer;

import dao.UserDAO;
import hibernatestuff.HibernateUtils;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.metamodel.Metamodel;
import model.Doctor;
import model.Donor;
import model.User;
import org.hibernate.*;

import java.util.UUID;


public class UserBLL {
    private UserDAO userDAO;
    private SessionFactory sessionFactory;
    private static UserBLL userBLL=new UserBLL();
    public UserBLL() {

        userDAO = new UserDAO();
        sessionFactory =  HibernateUtils.getSessionFactory();
        userDAO.setSessionFactory(sessionFactory);
    }

    public User loginUser(String username,String password)
    {

       int errorCode=0;
       User returned= userDAO.findOne(username);
       if(returned==null)
           errorCode=1;
       else
           if(returned.getUsername().equals(username))
               if(returned.getPassword().equals(password)) {

                   System.out.println("Logged in successfully!");
               }
               else {

                   System.out.println("Wrong password,try again");
               }
           else
           {
               errorCode=2;
               System.out.println("Wrong username, try again or Sign in!");
           }
           return returned;
    }

    public String getRole(String username,String password)
    {
        String role="";
        User returned= userDAO.findOne(username);
        if(returned.getUsername().equals(username))
            if(returned.getPassword().equals(password)) {
                if (returned.getClass().equals(Doctor.class))
                    role = "Doctor";
                if (returned.getClass().equals(Donor.class))
                    role = "Donor";
            }
        else
            role="Error";
        return role;
    }
    public User signIn(String username,String password,String firstName,String lastName,String email, String phone)
    {
        int errorCode=0;
        User returned= userDAO.findOne(username);
        if(returned!=null){
        if(returned.getUsername().equals(username) && returned.getFirstName().equals(firstName) && returned.getLastName().equals(lastName))
        {
            System.out.println("Account already exists");
            errorCode=1;
        }}
            User newUser = new Donor(UUID.randomUUID().toString().replaceAll("-", ""), username, password, firstName, lastName, email, phone);
            userDAO.create(newUser);
            System.out.println("Account created successfully!");


        return returned;
    }

}



