package com.verinite.paymentservice.repository;

import com.verinite.paymentservice.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository
public interface FeedbackRepository  extends JpaRepository<Feedback,Integer>{


    @Query(nativeQuery = true, value = "select o.id as owner_id,o.owner_name,o.email as owner_email,o.mobile_number,o.note,f.id as feedback_id,f.name,f.email as feed_email,f.suggestion,f.comments from feedback f inner join owner o on o.id= f.id")
    public List<Map<String,String>> findAllOwnerFeedback();

}