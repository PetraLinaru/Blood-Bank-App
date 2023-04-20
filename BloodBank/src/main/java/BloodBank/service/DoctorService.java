package BloodBank.service;

import BloodBank.model.Doctor;
import BloodBank.model.Role;

import java.util.List;
import java.util.UUID;

public interface DoctorService {
    Doctor registerDoctor(Doctor newDoctor);
    Doctor loginDoctor(String password, String email ) ;
    List<Doctor> getDoctors();
    void deleteDoctor(Doctor doctor);

    //extras
    Doctor findDoctorByEmail(String email);
    Doctor findDoctorByUUID(UUID uuid);
    Doctor findMaybeExistingDoctor(String firstName, String lastName, String email);
    Doctor editDoctor(Doctor oldUser, UUID oldUUID);
}
