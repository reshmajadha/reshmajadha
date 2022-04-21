package com.verinite.paymentservice.service;

import com.verinite.paymentservice.dto.PrescriptionDto;
import com.verinite.paymentservice.entity.Prescription;
import com.verinite.paymentservice.repository.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrescriptionServiceImpl implements PrescriptionService{

    @Autowired
    private PrescriptionRepository prescriptionRepository;

    @Override
    public Prescription insertPrescription(PrescriptionDto prescriptionDto) {
        Prescription prescription = new Prescription();
        prescription.setPrescriptionId(prescriptionDto.getPrescriptionId());
        prescription.setQuantity(prescriptionDto.getQuantity());
        prescription.setDoses(prescriptionDto.getDoses());
        prescription.setMedicineName(prescriptionDto.getMedicineName());
        prescription.setDoses(prescriptionDto.getDoses());
        prescription.setInstructions(prescriptionDto.getInstructions());
        return prescriptionRepository.save(prescription);
    }

    @Override
    public List<Prescription> getAllPrescription() {
        return prescriptionRepository.findAll();
    }

    @Override
    public String deletePrescription(Integer prescriptionId) {
        prescriptionRepository.deleteById(prescriptionId);
        return  "prescription deleted successfully";
    }

    @Override
    public List<String> allMedicinName() {
        return prescriptionRepository.allMedicinName();
    }


}
