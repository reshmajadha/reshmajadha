package com.verinite.paymentservice.repository;

import com.verinite.paymentservice.entity.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription, Integer> {


    @Query(value = "select  pharmacy_table.medicine_name from public.pharmacy_table",nativeQuery = true)
    public List<String> allMedicinName();
}
