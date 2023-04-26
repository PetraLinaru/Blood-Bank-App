package BloodBank.service.impl;

import BloodBank.Repository.DonorRepository;
import BloodBank.model.Donor;
import BloodBank.service.DonorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DonorServiceImpl implements DonorService {
    DonorRepository donorRepository;

    @Autowired
    public DonorServiceImpl(DonorRepository donorRepository) {
        this.donorRepository = donorRepository;
    }

    @Override
    public Donor registerDonor(Donor newDonor) {
        donorRepository.save(newDonor);
        return newDonor;
    }

    @Override
    public Donor loginDonor(String password, String email) {
        Donor found = (Donor) donorRepository.findDonorByEmailAndPassword(email, password);
        if (found != null)
            return found;
        else return null;
    }

    @Override
    public Donor getDonor(String verification) {
        return null;
    }

    @Override
    public Donor findDonorByEmail(String email) {
        Donor found = (Donor) donorRepository.findDonorByEmail(email);
        if (found != null)
            return found;
        else return null;
    }

    @Override
    public Donor findMaybeExistingDonor(String firstName, String lastName, String email) {
        return null;
    }

    @Override
    public Donor editDonor(Donor oldDonor) {
        Donor renewed = (Donor) donorRepository.save(oldDonor);
        return renewed;
    }

    @Override
    public Donor getDonorByUuid(UUID uuid) {
        Donor found = donorRepository.findDonorByUuid(uuid);
        return found;
    }

    public void deleteDonor(Donor donor)
    {
        donorRepository.delete(donor);
    }



    @Override
    public Donor updateDonor(Donor newDonor, UUID oldUUID)
    {
        donorRepository.updateDonor(newDonor.name, newDonor.email, newDonor.password, newDonor.blood_type,oldUUID);
        return newDonor;
    }

}
