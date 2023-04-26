package BloodBank.service.impl;

import BloodBank.Repository.UserRepository;
import BloodBank.model.User;
import BloodBank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

   final UserRepository userRepository;


   @Autowired
   public UserServiceImpl(UserRepository userRepository) {
      this.userRepository = userRepository;
   }

   @Override
   public User registerUser(User user) {
      User newUser=userRepository.save(user);
      return user;
   }

   @Override
   public User getUser(String verification) {
      return null;
   }

   @Override
   public User findUserByEmail(String email) {
      User found = userRepository.findUserByEmail(email);
      if (found!=null)
         return found;
      else return null;
   }

   @Override
   public User findUserByEmailAndPassword(String email, String password) {
      User found = userRepository.findUserByEmailAndPassword(email,password);
      if (found!=null)
         return found;
      else return null;
   }

   @Override
   public User findMaybeExistingUser(String firstName, String lastName, String email)
   {
//      User found=userRepository.findUserByEmailAndFirstNameAndLastName(email,firstName,lastName);
//      if (found!=null)
//         return found;
//      else return null;
      return null;
   }



   @Override
   public User loginUser(String password, String email) {
      User found =userRepository.findUserByEmailAndPassword(email,password);
      if (found!=null)
         return found;
      else return null;

   }
   @Override
   public User editUser(User newUser)
   {
      User renewed=userRepository.save(newUser);
      return renewed;
   }

   public void deleteUser(User oldUser)
   {
      userRepository.delete(oldUser);
   }

   public User findUserByUuid(UUID uuid)
   {
      User found=userRepository.findUserByUuid(uuid);
      return found;
   }



}
