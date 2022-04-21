package com.verinite.paymentservice;

import com.verinite.paymentservice.controller.VisitController;
import com.verinite.paymentservice.dto.VisitDto;
import com.verinite.paymentservice.dto.petvisit;
import com.verinite.paymentservice.entity.Pet;
import com.verinite.paymentservice.entity.PetEntity;
import com.verinite.paymentservice.entity.Visit;
import com.verinite.paymentservice.repository.PetRepository;
import com.verinite.paymentservice.repository.VisitRepository;
import com.verinite.paymentservice.service.VisitService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class VisitControllerTest {

    @Mock
    VisitService visitService;

    @Mock
    ModelMapper modelMapper;

    @Mock
    VisitRepository visitRepository;

    @Mock
    PetRepository petRepository;

    @InjectMocks
    VisitController visitController;

//    VisitDto visitDto = new VisitDto();


//    @Test
//    public void testinsertvisit() {
//        VisitDto visitDto = dummyVisitRequest();
//        Visit visit = dummyVisit();
//        VisitDto res = dummyVisitRequest();
////        when(modelMapper.map(visit, VisitDto.class)).thenReturn(visitDto);
////        when(visitService.insertVisit(visit)).thenReturn(visit);
//        ResponseEntity<VisitDto> response = visitController.insertVisit(visitDto);
//        assertNotNull(response);
//    }

    Visit dummyVisit() {
        Visit visit = new Visit();
        visit.setId(1);
        visit.setPet_id(1);
        visit.setDescription("qwerf");
        visit.setDate(new Date(2022 / 02 / 8));
        visit.set_delete(true);
        return visit;
    }

    VisitDto dummyVisitRequest() {
        VisitDto visitDto = new VisitDto();
        Visit visit = dummyVisit();
        visit.setId(visit.getId());
        visit.setPet_id(visit.getPet_id());
        visit.setDescription(visit.getDescription());
        visit.setDate(visit.getDate());
        visit.set_delete(visit.is_delete());
        return visitDto;
    }

    @Test
    public void test_insertVisit() {
        Visit visit = dummyVisit();
        when(visitService.insertVisit(visit)).thenReturn(visit);
        Visit response = visitController.insertVisit(visit);
        assertNotNull(response);
    }

    @Test
    public void test_getById() {
        Visit visit = dummyVisit();
        int id = 1;
        System.out.println("reponse:+response");
        when(visitService.getById(1)).thenReturn(visit);
        Object response = visitController.getById(1);
        assertNotNull(visit);
        assertNotNull(response);
    }

    @Test
    public void test_getAll() {
        Visit visit = dummyVisit();
        List<Visit> list = new ArrayList<>();
        //when(visitService.allVisit()).thenReturn(visit);
        List<Visit> response = visitController.allVisit();
        assertNotNull(visit);
        assertNotNull(response);
    }

    @Test
    public void test_updateVisit() {
        Visit visit = dummyVisit();
        VisitDto visitDto = dummyVisitRequest();
        Integer id = 1;
        Visit res = dummyVisit();
        when(visitService.updateVisit(id, visit)).thenReturn(res);
        Object response = visitController.updateVisit(id, visit);
        assertNotNull(response);
    }

    @Test
    public void test_deleteById() {
        Visit visit = dummyVisit();
        String res = "visit deleted successfully";
        Integer id = 1;
        when(visitService.deleteById(id)).thenReturn(res);
        String response = visitController.deleteById(1);
        assertNotNull(response);
    }

    @Test
    public void test_getVisitById() {
        Visit visit = dummyVisit();
        Integer id = 1;
        when(visitService.getById(id)).thenReturn(visit);
        Object response = visitController.getById(id);
        assertNotNull(response);
    }

    @Test
    public void test_deleteVisit() {
        int id = 1;
        Visit visit = dummyVisit();
        Visit res = dummyVisit();
        visitService.deleteVisit(id);
        visitController.deleteVisit(id);
        assertNotNull(res);
    }

    petvisit dummyPetVisit() {
        petvisit petvisit = new petvisit();
        petvisit.setId(1);
        petvisit.setPet_id(2);
        petvisit.setDate(new Date(2022 / 02 / 14));
        petvisit.setDescription("welcome");
        petvisit.setIsd_delete(true);
        petvisit.setPet_name("cat");
        petvisit.setOwner_name("Ress");
        petvisit.setSpecies_id(2);
        petvisit.setPet_species("fever");
        petvisit.setPet_symptoms("fsfdf");
        petvisit.setVisit_id(1);
        return petvisit;
    }
//    petvisit dummyPetVisitRequest() {
//        petvisit petvisit = new petvisit();
//        petvisit petvisit1 = dummyPetVisit();
//        petvisit1.setId(petvisit1.getId());
//        petvisit1.setPet_id(petvisit1.getPet_id());
//        petvisit1.setDate(petvisit1.getDate());
//        petvisit1.setDescription(petvisit1.getDescription());
//
//        petvisit1.setPet_name(petvisit1.getPet_name());
//        petvisit1.setOwner_name(petvisit1.getOwner_name());
//        petvisit1.setSpecies_id(petvisit1.getSpecies_id());
//        petvisit1.setPet_species(petvisit1.getPet_species());
//        petvisit1.setPet_symptoms(petvisit1.getPet_symptoms());
//        petvisit1.setVisit_id(petvisit1.getVisit_id());
//        return petvisit1;
//    }
//

    PetEntity dummPetEntity() {
        PetEntity petEntity = new PetEntity();
        petEntity.setPet_id(1);
        petEntity.setPet_name("abc");
        petEntity.setOwner_name("abc");
        petEntity.setSpecies_id(1);
        petEntity.setPet_species("ny");
        petEntity.setPet_symptoms("abc");
        petEntity.set_delete(false);
        petEntity.setVisit_id(1);
        return petEntity;
    }

    @Test
    public void test_petVisitList() {
        petvisit petvisit = dummyPetVisit();
        Visit visit = dummyVisit();
        PetEntity petEntity = dummPetEntity();
        petEntity.setPet_id(petvisit.getPet_id());
        visit.setPet_id(visit.getPet_id());
        List<Map<String, String>> petVisit = visitRepository.findAllPetVisitRecords();
        when(visitRepository.findAllPetVisitRecords()).thenReturn(petVisit);
        List<Map<String, String>> response = visitController.allpetvisit();
        assertNotNull(response);
    }

    @Test
    public void test_updatepetVisit() {
        petvisit petvisit = dummyPetVisit();
        Visit visit = dummyVisit();
        PetEntity petEntity = dummPetEntity();
        int id = 1;
        //Visit visit1 =visitRepository.getById(id);
        when(visitRepository.getById(id)).thenReturn(visit);
        when(visitRepository.save(visit)).thenReturn(visit);
//        when(petRepository.save(petEntity)).thenReturn(petEntity);
        petvisit response = visitController.updatepetvisit(petvisit);
        assertNotNull(response);
    }

}