package BloodBank.service;

import BloodBank.model.Doctor;
import BloodBank.model.Donor;
import BloodBank.model.User;

import java.util.UUID;

public interface DonorService {
    Donor registerDonor(Donor newDonor);
    Donor loginDonor(String password, String email ) ;

    Donor getDonor(String verification);

    //extras
    Donor findDonorByEmail(String email);
    Donor findMaybeExistingDonor(String firstName, String lastName, String email);
    Donor editDonor(Donor oldDonor);
    Donor getDonorByUuid(UUID uuid);
    void deleteDonor(Donor donor);
    Donor updateDonor(Donor donor, UUID uuid);

}
