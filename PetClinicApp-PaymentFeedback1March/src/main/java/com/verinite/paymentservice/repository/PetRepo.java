package com.verinite.paymentservice.repository;


import com.verinite.paymentservice.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface PetRepo extends JpaRepository<Pet,Integer> {


}
