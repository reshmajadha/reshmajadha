package com.verinite.paymentservice.controller;

import com.verinite.paymentservice.dto.VisitDto;
import com.verinite.paymentservice.dto.petvisit;
import com.verinite.paymentservice.entity.PetEntity;
import com.verinite.paymentservice.entity.Visit;
import com.verinite.paymentservice.repository.PetRepository;
import com.verinite.paymentservice.repository.VisitRepository;
import com.verinite.paymentservice.service.VisitService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

@RequestMapping("/visit")
public class VisitController {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    VisitService visitService;
    @Autowired
    VisitRepository visitRepository;
    @Autowired
    PetRepository petRepository;

//    @PostMapping("/save")
//    public ResponseEntity<VisitDto> insertVisit(@RequestBody VisitDto visitdto) {
//        Visit visitreq = modelMapper.map(visitdto, Visit.class);
//        Visit visit = visitService.insertVisit(visitreq);
//        visitdto = modelMapper.map(visit, VisitDto.class);
//        return new ResponseEntity<>(visitdto, HttpStatus.CREATED);
//    }

    @PostMapping("/save")
    public Visit insertVisit(@RequestBody Visit visit) {
        return visitService.insertVisit(visit);
    }

    @GetMapping("/getAll")
    public List<Visit> allVisit() {
        return visitService.allVisit();
    }

    @PutMapping("/updateVisit/{id}")
    public Object updateVisit(@PathVariable Integer id, @RequestBody Visit visit) {
        Object b = visitService.updateVisit(id, visit);
        return b;

    }

    @DeleteMapping("/delete-byId/{id}")
    public String deleteById(@PathVariable("id") Integer id) {
        return visitService.deleteById(id);

    }

    @GetMapping("/get-visit/{id}")
    public Object getById(@PathVariable("id") int id) {
        return visitService.getById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteVisit(@PathVariable("id") int id) {
        visitService.deleteVisit(id);
    }

    @GetMapping("/petvisitlist")
    public List<Map<String, String>> allpetvisit() {
        return visitRepository.findAllPetVisitRecords();
    }

    @PutMapping("/updatepetvisit")
    public petvisit updatepetvisit(@RequestBody petvisit ob) {
        Visit visit = visitRepository.getById(ob.getId());
        visit.setPet_id(ob.getPet_id());
        visit.setDate(ob.getDate());
        visit.setDescription(ob.getDescription());
        visitRepository.save(visit);
        PetEntity pet = new PetEntity();
        pet.setPet_id(visit.getPet_id());
        pet.setPet_name(ob.getPet_name());
        pet.setOwner_name(ob.getOwner_name());
        pet.setSpecies_id(ob.getSpecies_id());
        pet.setPet_species(ob.getPet_species());
        pet.set_delete(ob.isIsd_delete());
        pet.setVisit_id(ob.getVisit_id());
        pet.setPet_symptoms(ob.getPet_symptoms());
        petRepository.save(pet);
        return ob;

    }
}
