package com.verinite.paymentservice.service;


import com.verinite.paymentservice.entity.Visit;

import java.util.List;

public interface VisitService {
    //public Visit insertVisit(Visit visit) ;
    public Visit insertVisit(Visit visit) ;
    public  Visit insertVisit1(Visit visit);

    public  List<Visit> allVisit() ;

    public String deleteById(int id);

    String deleteById(Integer id);

    public  Object updateVisit(Integer id, Visit visit) ;

    public Object getById(int id);

    void deleteVisit(int id);
}
