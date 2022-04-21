package com.verinite.paymentservice.repository;

import com.verinite.paymentservice.entity.Payments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payments,Integer> {


    @Query(value="select * from public.Payment_Table  Where is_delete=false",nativeQuery = true)
    List<Payments> getAllPaymentUndeletedList();
	
}
