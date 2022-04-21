package com.verinite.paymentservice.service;



import com.verinite.paymentservice.entity.Visit;
import com.verinite.paymentservice.repository.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class VisitServiceImpl implements VisitService {

    @Autowired
    VisitRepository visitRepository;

//    @Override
//    public Visit insertVisit(Visit visit) {
//
//        visit.setPet_id(visit.getPet_id());
//        visit.setDate(visit.getDate());
//        visit.setDescription(visit.getDescription());
//        visit.set_delete(false);
//        return visitRepository.save(visit);
//    }

    @Override
    public Visit insertVisit(Visit visit) {
//        visit.setId(visit.getId());
        visit.setPet_id(visit.getPet_id());
        visit.setDate(visit.getDate());
        visit.setDescription(visit.getDescription());

        visit.set_delete(false);
        return visitRepository.save(visit);
    }
    @Override
    public Visit insertVisit1(Visit visit) {
        return visitRepository.save(visit);
    }


    @Override
    public List<Visit> allVisit() {
        return visitRepository.find();
    }

    @Override
    public String deleteById(int id) {
        return null;
    }

    @Override
    public String deleteById(Integer id)
    {
        Visit visit = visitRepository.getById(id);
        if (!visit.is_delete()) {
            visit.set_delete(true);
            visitRepository.save(visit);
            return "visit record Successfully deleted";
        } else
        {
            return "Given visit Id is already deleted";
        }
    }

    @Override
    public Object updateVisit(Integer id, Visit visit)
    {
        try {
            Visit oldVisitTable = visitRepository.getById(id);
            oldVisitTable.setPet_id(visit.getPet_id());
            oldVisitTable.setDate(visit.getDate());
            oldVisitTable.setDescription(visit.getDescription());
            oldVisitTable.set_delete(false);
            return visitRepository.save(oldVisitTable);
        } catch (Exception e) {
            return "record is not present to update with id of " + id;
        }
    }

    // getby id
    @Override
    public Object getById(int id) {
        try {
            visitRepository.findById(id).get();
            return visitRepository.getById(id);
        } catch (Exception e) {
            return id + "this Id not Found in record";
        }
    }

    // delete method
    @Override
    public void deleteVisit(int id)
    {
        visitRepository.deleteById(id);
    }



}
