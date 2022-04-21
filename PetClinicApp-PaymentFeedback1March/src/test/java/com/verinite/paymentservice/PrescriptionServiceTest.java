package com.verinite.paymentservice;

import com.verinite.paymentservice.dto.PrescriptionDto;
import com.verinite.paymentservice.entity.Prescription;
import com.verinite.paymentservice.entity.Visit;
import com.verinite.paymentservice.repository.PrescriptionRepository;
import com.verinite.paymentservice.service.PrescriptionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)

public class PrescriptionServiceTest {
    @InjectMocks
    PrescriptionService prescriptionService;

    @MockBean
    PrescriptionRepository prescriptionRepository;

    @Test
    public void save_prescription(){
        Prescription prescription=dummyPrescription();
        when(prescriptionRepository.findAll()).thenReturn((List<Prescription>) prescription);


    }

    public Prescription dummyPrescription() {
        Prescription prescription = dummyPrescription();
        prescription.setPrescriptionId(1);
        prescription.setMedicineName("asd");
        prescription.setDoses("sd");
        prescription.setQuantity(2);
        prescription.setInstructions("dfvc");
        return prescription;
    }
    public PrescriptionDto dummyPrescriptionRequest(){
        PrescriptionDto prescriptionDto=dummyPrescriptionRequest();
        prescriptionDto.setPrescriptionId(prescriptionDto.getPrescriptionId());
        prescriptionDto.setMedicineName(prescriptionDto.getMedicineName());
        prescriptionDto.setDoses(prescriptionDto.getDoses());
        prescriptionDto.setQuantity(prescriptionDto.getQuantity());
        prescriptionDto.setInstructions(prescriptionDto.getInstructions());
        return prescriptionDto;

    }


}
