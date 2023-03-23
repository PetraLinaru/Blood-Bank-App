package hibernatestuff;

import businesslayer.LoginBLL;
import businesslayer.RolesBLL;
import businesslayer.UserBLL;
import dao.UserDAO;
import model.Doctor;
import model.Donor;
import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.engine.jdbc.BinaryStream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class HibernateMain {
    public static void main(String[] args) throws IOException {

        System.out.println("Pick : \n 1.Login\n 2.SignUP");



        //IT s not much but it's honest work.
        // la prima rulare o sa functioneze si signup, apoi nu mai functioneaza  (am eroare de azi noapte)
        //(?? am stat azi noapte sa vad de ce nu merge si doar stricam proiectul


       LoginBLL loginBLL=new LoginBLL();

        String val = "10";
        String username="";
        String password="";
        String firstName= "";
        String lastName="";
        String phone="";
        String email="";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (val != "0") {

            val = String.valueOf(br.readLine());
            switch (val) {
                case "1":
                    System.out.println("Username\n");
                    System.out.println("Password\n");
                    String cmd= null;
                    try {
                        username = br.readLine();
                        password=br.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    System.out.println(username+"  "+password);
                    loginBLL.loginUser(username,password);

                    break;
                case "2":
                    System.out.println("Donor Sign in: \n");
                    System.out.println("Username\n");
                    username=br.readLine();
                    System.out.println("Password\n");
                    password=br.readLine();
                    System.out.println("First Name\n");
                    firstName=br.readLine();
                    System.out.println("Last Name\n");
                    lastName=br.readLine();
                    System.out.println("Email\n");
                    email=br.readLine();
                    System.out.println("Phone\n");
                    phone=br.readLine();
                    loginBLL.signInUser(username,password,firstName,lastName,phone,email);
                    break;
            }
        }
    }
}

