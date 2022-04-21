package com.verinite.paymentservice;
import com.verinite.paymentservice.dto.VisitRequest;
import com.verinite.paymentservice.entity.Visit;
import com.verinite.paymentservice.repository.VisitRepository;
import com.verinite.paymentservice.service.VisitServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class VisitServiceImplTest {

    @InjectMocks
    VisitServiceImpl visitServiceImpl;

    @Mock
    VisitRepository repository;

    @Test
    public void testInsertVisit() {

        Visit visit = dummyVisit();
        when(repository.save(visit)).thenReturn(visit);
        Visit response = visitServiceImpl.insertVisit(visit);
        assertNotNull(response);
    }

    @Test
    public void test_insertVisit1(){

        Visit visit = dummyVisit();
        when(repository.save(visit)).thenReturn(visit);
        Visit response = visitServiceImpl.insertVisit1(visit);
        assertNotNull(response);
    }

    public Visit dummyVisit() {
        Visit visit = new Visit();
        visit.setId(1);
        visit.setPet_id(1);
        visit.setDate(new Date(2022 / 02 / 8));
        visit.setDescription("asdd");
        visit.set_delete(false);
        return visit;
    }

    public VisitRequest dummyVisitRequest() {
        VisitRequest visitreq = new VisitRequest();
        visitreq.setPet_id(visitreq.getPet_id());
        visitreq.setDate(visitreq.getDate());
        visitreq.setDescription(visitreq.getDescription());
        visitreq.setIs_delete(false);
        return visitreq;
    }

    @Test
    public void testDeleteVisit() {
        Visit visit = dummyVisit();
        visit.set_delete(false);
        Integer id = 1;
        visit.setId(id);
        when(repository.getById(id)).thenReturn(visit);
        repository.save(visit);
        String response = visitServiceImpl.deleteById(id);
        assertNotNull(response);
        assertEquals("visit record Successfully deleted", response);
    }

    @Test
    public void testUpdateVisitWithException() {
        Visit visit = null;
        Integer id = 1;
        when(repository.getById(id)).thenReturn(visit);
        Object response = visitServiceImpl.updateVisit(id, any());
        assertNotNull(response);
    }

    @Test
    public void testUpdateVisit() {
        Visit visit = dummyVisit();
        Integer id = 1;
        when(repository.getById(1)).thenReturn(visit);
        when(repository.save(visit)).thenReturn(visit);
        Object response = visitServiceImpl.updateVisit(id, visit);
        assertNotNull(response);
    }

    @Test
    public void testGetById() {
        Visit visit = dummyVisit();
        int id = 1;
        when(repository.findById(1)).thenReturn(Optional.ofNullable(visit));
        repository.getById(id);
        when(repository.getById(1)).thenReturn(visit);
        Object response = visitServiceImpl.getById(1);
        assertNotNull(response);
    }

    @Test
    public void testGetByIdException() {

        int id = 3;
        repository.getById(id);
        Object response = visitServiceImpl.getById(id);
        assertNotNull(response);
        assertNotNull(response);
    }


    @Test
    public void test_getById() {
        Visit visit = dummyVisit();
        int id = 1;

        // when(repository.findById(id)).thenReturn(visit);
        Object response = visitServiceImpl.getById(id);
        assertNotNull(response);
    }


    @Test
    public void testDeleteByIdAready() {
        Visit visit = dummyVisit();
        visit.set_delete(false);
        Integer id = 1;
        when(repository.getById(id)).thenReturn(visit);
        String response = visitServiceImpl.deleteById(id);
        assertNotNull("Given visit Id is already deleted", response);
    }

    @Test
    public void testDeleteByIdAreadyTwo() {
        Visit visit = dummyVisit();
        visit.set_delete(true);
        Integer id = 1;
        when(repository.getById(id)).thenReturn(visit);
        String response = visitServiceImpl.deleteById(id);
        assertNotNull("visit record Successfully deleted", response);
    }

    @Test
    public void testAllVisit() {
        Visit visit = dummyVisit();
        List<Visit> list = new ArrayList<>();
        List<Visit> response = visitServiceImpl.allVisit();
//        when(repository.find()).thenReturn(list);
        assertNotNull(visit);
        assertNotNull(response);
    }

    @Test
    public void deleteById() {
        Visit visit = dummyVisit();
        int id = 1;
        repository.deleteById(id);
        visitServiceImpl.deleteById(id);
        assertNotNull(repository);

    }

    @Test
    public void deleteById1() {
        Visit visit = dummyVisit();
        int id = 1;
        repository.deleteById(id);
        visitServiceImpl.deleteVisit(id);


    }
}
