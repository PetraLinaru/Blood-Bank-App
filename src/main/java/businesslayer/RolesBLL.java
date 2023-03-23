package businesslayer;

import model.User;

public class RolesBLL {
    static UserBLL currentUserBLL;
    static User currentUser;
    static String role;

    public RolesBLL() {
        currentUserBLL = new UserBLL();
    }

    public void setCurrentUser(String username, String password) {
        User aux = currentUserBLL.loginUser(username, password);
        currentUser = aux;

    }

    public void setCurrentRole() {
        String role = "";
        System.out.println(currentUser.getClass());
        switch (currentUser.getClass().toString()) {
            case "class model.Donor":
                System.out.println("I am Donor");
                this.role = "Donor";
                break;
            case "class model.Doctor":
                System.out.println("I am Doc");
                this.role = "Doctor";
                break;
            case "class model.User":
                if (currentUser.getUsername().equals("ADMIN"))
                    System.out.println("tzapa, ai dat de sefu");
                this.role = "ADMIN";
        }
    }

    public void signInUser(String username, String password, String firstName, String lastName, String phone, String email) {
        User aux = currentUserBLL.signIn(username, password, firstName, lastName, phone, email);
    }

    public User getCurrentUser() {
        return this.currentUser;
    }

    public String getRole()
    {
        return this.role;
    }


}
