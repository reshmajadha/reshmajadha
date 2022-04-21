package com.verinite.paymentservice.service;

import com.verinite.paymentservice.dto.PrescriptionDto;
import com.verinite.paymentservice.entity.Prescription;

import java.util.List;

public interface PrescriptionService {

    Prescription insertPrescription(PrescriptionDto prescription);
    List<Prescription>  getAllPrescription();
    String deletePrescription(Integer prescriptionId);
    List<String> allMedicinName();



}
