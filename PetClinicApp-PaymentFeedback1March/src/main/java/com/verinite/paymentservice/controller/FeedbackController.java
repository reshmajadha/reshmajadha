package com.verinite.paymentservice.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;


import com.verinite.paymentservice.dto.FeedbackDto;
import com.verinite.paymentservice.entity.Feedback;
import com.verinite.paymentservice.repository.FeedbackRepository;
import com.verinite.paymentservice.service.FeedbackService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    @Autowired
    FeedbackService feedbackService;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    FeedbackRepository feedbackRepository;

    @PostMapping("/save")
    public FeedbackDto insertFeedback(@RequestBody FeedbackDto feedbackDto) {
        Feedback FeedbackRequest = modelMapper.map(feedbackDto, Feedback.class);
        Feedback feedback = feedbackService.insertFeedback(FeedbackRequest);
        return  modelMapper.map(feedback, FeedbackDto.class);

    }
    @GetMapping("/getAll")
    public List<Feedback> allFeedback() {
        return feedbackService.allFeedback();
    }
    @PutMapping("/updateFeedback/{id}")
    public Object updateFeedback(@PathVariable int id, @RequestBody Feedback feedback ){
        return feedbackService.updateFeedback(id, feedback);

    }
    @DeleteMapping("/delete-byId/{id}")
    public String deleteById(@PathVariable("id") int id) {
        return feedbackService.deleteById(id);

    }
    @DeleteMapping("/delete/{id}")
    public void deleteFeedback1(@PathVariable int id) {
        feedbackService.deleteFeedback(id);
    }

    @GetMapping("/getById/{id}")
    public Optional<Feedback> getById(@PathVariable("id") Integer id) {
        return feedbackService.getById(id);
    }



    @GetMapping("/getAllList")
    public List<Map<String,String>> allOwnerFeedback() {
        return (List<Map<String, String>>) feedbackRepository.findAllOwnerFeedback();
    }
}
