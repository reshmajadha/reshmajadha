package com.verinite.paymentservice.service;
import com.verinite.paymentservice.entity.Feedback;

import java.util.List;
import java.util.Optional;



public interface FeedbackService {

	Feedback insertFeedback(Feedback feedback);

	Object updateFeedback(int id, Feedback feedback);



	List<Feedback> allFeedback();

	String deleteById(int id);

	void deleteFeedback(int id);

	Optional<Feedback> getById(Integer id);


}