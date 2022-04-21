package com.verinite.paymentservice.service;

import com.verinite.paymentservice.dto.PetPharmacy;
import com.verinite.paymentservice.entity.Pet;
import com.verinite.paymentservice.entity.Pharmacy;
import com.verinite.paymentservice.repository.PetRepo;
import com.verinite.paymentservice.repository.PharmacyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Transactional
@Service
public class PharmacyServiceImpl implements PharmacyService {
    @Autowired
    private PharmacyRepo pharmacyRepo;
    @Autowired
    private PetRepo petRepo;

    @Override
    public Pharmacy savePharmacy(Pharmacy pharmacy) {
        return pharmacyRepo.save(pharmacy);
    }

    @Override
    public List<Pharmacy> allPharmacyRecords() {
        return pharmacyRepo.findAll();
    }

    @Override
    public Optional<Pharmacy> getById(Integer medicine_id) {
        Optional<Pharmacy> pharmacy=pharmacyRepo.findById(medicine_id);
        return pharmacy;
    }

    @Override
    public String  deletePharmacyById(Integer medicine_id) {
        pharmacyRepo.deleteById(medicine_id);
        return "Record deleted successfully";

    }
    public PetPharmacy insertPetPharmacy(PetPharmacy petPharmacy){
        Pharmacy pharmacy1=new Pharmacy();
        pharmacy1.setMedicine_name(petPharmacy.getMedicine_name());
        pharmacy1.setPrice(petPharmacy.getPrice());
        pharmacy1.setQuantity(petPharmacy.getQuantity());
        pharmacy1.setDescription(petPharmacy.getDescription());
        pharmacy1.setMedicine_expiry_date(petPharmacy.getMedicine_expiry_date());
        pharmacy1.setPet_id(petPharmacy.getPetId());
        pharmacy1.setMedicine_id(petPharmacy.getMedicine_id());
        pharmacyRepo.save(pharmacy1);
        Pet pet= new Pet();
        pet.setPetName(petPharmacy.getPet_name());
        pet.setPetSpecies(petPharmacy.getPet_species());
        pet.setPetSymptoms(petPharmacy.getPetSymptoms());
        pet.setUsername(petPharmacy.getUsername());
        pet.setPetSymptoms(pet.getPetSymptoms());
        pet.setSpeciesId(pet.getSpeciesId());
        petRepo.save(pet);
        return petPharmacy;
    }

    @Override
    public List<Map<String, String>> petPharmacies() {
        return pharmacyRepo.findAllPetPharmacyRecords();
    }

    @Override
    public Pharmacy updatePharmacy(Integer medicine_id,Pharmacy pharmacy) {
        Pharmacy  pharmacy1 = pharmacyRepo.getById(medicine_id);
        pharmacy1.setMedicine_name(pharmacy.getMedicine_name());
        pharmacy1.setPrice(pharmacy.getPrice());
        pharmacy1.setQuantity(pharmacy.getQuantity());
        pharmacy1.setDescription(pharmacy.getDescription());
        pharmacy1.setMedicine_expiry_date(pharmacy.getMedicine_expiry_date());
        pharmacy1.setPet_id(pharmacy.getPet_id());
        return pharmacyRepo.save(pharmacy1);
    }

//    @Override
//    public PetPharmacy updatePetPharmacy(PetPharmacy petPharmacy) {
//        Pharmacy pharmacy1 = pharmacyRepo.getById(petPharmacy.getMedicine_id());
//        pharmacy1.setMedicine_name(petPharmacy.getMedicine_name());
//        pharmacy1.setPrice(petPharmacy.getPrice());
//        pharmacy1.setQuantity(petPharmacy.getQuantity());
//        pharmacy1.setDescription(petPharmacy.getDescription());
//        pharmacy1.setMedicine_expiry_date(petPharmacy.getMedicine_expiry_date());
//        pharmacy1.setPet_id(petPharmacy.getPetId());
//        pharmacyRepo.save(pharmacy1);
//        Pet pet= petRepo.getById(pharmacy1.getPet_id());
//        pet.setPetName(petPharmacy.getPet_name());
//        pet.setPetSpecies(petPharmacy.getPet_species());
//        pet.setPetSymptoms(petPharmacy.getPetSymptoms());
//
//        pet.setOwnerName(petPharmacy.getOwner_name());
//        pet.setPetSymptoms(pet.getPetSymptoms());
//        petRepo.save(pet);
//        return petPharmacy;
//    }

}