package com.verinite.paymentservice.repository;

import com.verinite.paymentservice.entity.TermsCondition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TermsRepository extends JpaRepository<TermsCondition,String>{

}