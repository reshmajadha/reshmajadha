package com.verinite.paymentservice.repository;

import com.verinite.paymentservice.entity.ContactUs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ContactRepository extends JpaRepository<ContactUs,String> {

}