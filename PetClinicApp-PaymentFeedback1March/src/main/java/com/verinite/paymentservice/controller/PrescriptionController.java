package com.verinite.paymentservice.controller;


import com.verinite.paymentservice.dto.PrescriptionDto;
import com.verinite.paymentservice.entity.Prescription;
import com.verinite.paymentservice.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/prescription")
public class PrescriptionController {

    @Autowired
    PrescriptionService prescriptionService;

    @PostMapping("/insert")
    public Prescription insertPrescription(@RequestBody PrescriptionDto prescriptionDto){
        return  prescriptionService.insertPrescription(prescriptionDto);
    }

    @GetMapping("/allPrescription")
    public List<Prescription> findAllPrescription(){
        return prescriptionService.getAllPrescription();
    }

    @DeleteMapping("/deleteById")
    public  String deletePrescription(@PathVariable Integer prescriptionId){
        return  prescriptionService.deletePrescription(prescriptionId);
    }

    @GetMapping("/allMedicinName")
    public List<String> allMedicinName(){
        return prescriptionService.allMedicinName();
    }




}
