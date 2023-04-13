package BloodBank.facade;

import BloodBank.model.User;

public interface UserFacade
{
   User registerUser(User user);
   public User getUserByEmail(String user);
}

