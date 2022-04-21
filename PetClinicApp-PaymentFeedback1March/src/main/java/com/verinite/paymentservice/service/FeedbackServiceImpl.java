package com.verinite.paymentservice.service;

import java.util.List;
import java.util.Optional;

import com.verinite.paymentservice.entity.Feedback;
import com.verinite.paymentservice.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FeedbackServiceImpl implements FeedbackService {
	@Autowired
	FeedbackRepository feedbackRepository;

	@Override
	public Feedback insertFeedback(Feedback feedback) {

		feedback.setName(feedback.getName());
		feedback.setEmail(feedback.getEmail());
		feedback.setSuggestion(feedback.getSuggestion());
		feedback.setScale(feedback.getScale());
		feedback.setComments(feedback.getComments());
		feedback.setDelete(feedback.isDelete());
		return feedbackRepository.save(feedback);
	}


	@Override
	public Object updateFeedback(int id, Feedback feedbackRequest) {
		try {
			Feedback oldFeedbackTable = feedbackRepository.getById(id);
			oldFeedbackTable.setName(feedbackRequest.getName());
			oldFeedbackTable.setEmail(feedbackRequest.getEmail());
			oldFeedbackTable.setSuggestion(feedbackRequest.getSuggestion());
			oldFeedbackTable.setScale(feedbackRequest.getScale());
			oldFeedbackTable.setComments(feedbackRequest.getComments());
			oldFeedbackTable.setDelete(false);
			return feedbackRepository.save(oldFeedbackTable);
		} catch (Exception e) {
			return "record is not present to update with id of " + id;
		}

	}

	@Override
	public List<Feedback> allFeedback() {

		return feedbackRepository.findAll();
	}


	@Override
	public String deleteById(int id) {
		try {
			Feedback feedback = feedbackRepository.getById(id);
			if (!feedback.isDelete()) {
				feedback.setDelete(true);
				feedbackRepository.save(feedback);

				return "feedback record Successfully deleted";
			} else {
				return "Given feedbackId is already deleted";
			}
		} catch (Exception e) {
			return "Id not Found";
		}

	}


	@Override
	public void deleteFeedback(int id) {

		feedbackRepository.deleteById(id);

	}

	@Override
	public Optional<Feedback> getById(Integer id) {
		return feedbackRepository.findById(id);
	}



}