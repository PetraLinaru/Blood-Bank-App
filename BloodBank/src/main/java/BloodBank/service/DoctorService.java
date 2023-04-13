package BloodBank.service;

import BloodBank.model.Doctor;
import BloodBank.model.Role;

public interface DoctorService {
    Doctor registerDoctor(Doctor newDoctor);
   Doctor loginDoctor(String password, String email ) ;

    Doctor getDoctor(String verification);

    //extras
    Doctor findDoctorByEmail(String email);
    Doctor findMaybeExistingDoctor(String firstName, String lastName, String email);
    Doctor editDoctor(Doctor oldUser);
}
