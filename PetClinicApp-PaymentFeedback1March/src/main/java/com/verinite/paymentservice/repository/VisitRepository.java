package com.verinite.paymentservice.repository;


import com.verinite.paymentservice.entity.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface VisitRepository extends JpaRepository <Visit, Integer> {
    @Query(value="select * from public.tbl_visiit  Where is_delete=false Order by id ASC",nativeQuery = true)
    List<Visit> find();

//    @Query(value = " select p.pet_id as pet_id1,p.pet_name,p.owner_name,p.pet_species,p.pet_symptoms,p.species_id,p.visit_id,v.id,v.date,v.description,v.pet_id,v.is_delete\n" +
//            "\t\t\t from tbl_pet p inner join\n" +
//            "\t\t\ttbl_visiit v on v.pet_id  = p.pet_id;",nativeQuery = true)
//    public List<Map<String,String>> findAllPetVisitRecords();
//

    @Query(value = " select p.pet_id as pet_id1,p.pet_name,p.username,p.pet_species,p.pet_symptoms,p.species_id,v.id,v.date,v.description,v.pet_id,v.is_delete from pet p inner join tbl_visiit v on v.pet_id  = p.pet_id",nativeQuery = true)
    public List<Map<String,String>> findAllPetVisitRecords();

//
//    @Query(value="select * from public.tbl_visiit  Where is_delete=false Order by id ASC",nativeQuery = true)
//    List<Visit> find();
//    @Query(value = " select p.pet_id as pet_id1,p.pet_name,p.owner_name,p.pet_species,p.pet_symptoms,p.species_id,v.id,v.date,v.description,v.pet_id,v.is_delete\n" +
//            "\t\t\t from pet p inner join\n" +
//            "\t\t\ttbl_visiit v on v.pet_id  = p.pet_id;",nativeQuery = true)
//    public List<Map<String,String>> findAllPetVisitRecords();
}
