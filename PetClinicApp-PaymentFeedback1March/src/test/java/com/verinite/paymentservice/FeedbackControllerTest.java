package com.verinite.paymentservice;


import com.verinite.paymentservice.controller.FeedbackController;
import com.verinite.paymentservice.dto.FeedbackDto;
import com.verinite.paymentservice.entity.Feedback;
import com.verinite.paymentservice.repository.FeedbackRepository;
import com.verinite.paymentservice.service.FeedbackService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;


import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class FeedbackControllerTest {
    @Mock
    FeedbackService feedbackService;
    @Mock
    ModelMapper modelMapper;
    @InjectMocks
    FeedbackController feedbackController;

    @Mock
    FeedbackRepository feedbackRepository;

    @Test
    public void test_insertFeedback() {
        FeedbackDto feedbackDto = dummyfeedbackdto();
        FeedbackDto feedbackRequest = dummyFeedbackRequest();
        FeedbackDto res = dummyFeedbackRequest();
        Feedback feedback = dummyFeedback();
        when(modelMapper.map(feedback, FeedbackDto.class)).thenReturn(feedbackDto);
        when(feedbackService.insertFeedback(Mockito.any())).thenReturn(feedback);
        FeedbackDto response = feedbackController.insertFeedback(feedbackRequest);
        assertNotNull(response);

    }

    Feedback dummyfeedback() {
        Feedback feedback = new Feedback();
        feedback.setName("name");
        feedback.setScale(1);
        feedback.setSuggestion("asas");
        feedback.setEmail("aaa");
        feedback.setDelete(false);
        feedback.setId(1);
        feedback.setComments("aaa");
        return feedback;
    }

    private FeedbackDto dummyfeedbackdto() {
        FeedbackDto feedbackDto = new FeedbackDto();
        feedbackDto.setId(1);
        feedbackDto.setName("name");
        feedbackDto.setScale(1);
        feedbackDto.setComments("asa");
        feedbackDto.setEmail("abc@gmail.com");
        feedbackDto.setSuggestion("aaa");
        return feedbackDto;
    }

    Feedback dummyFeedback() {
        Feedback feedback = new Feedback();
        feedback.setId(1);
        feedback.setName("name");
        feedback.setDelete(false);
        feedback.setComments("hiii");
        feedback.setSuggestion("no");
        feedback.setEmail("sap@gmail.com");
        feedback.setScale(1);
        feedback.setName("payal");
        return feedback;
    }

    FeedbackDto dummyFeedbackRequest() {
        FeedbackDto feedbackRequest = new FeedbackDto();
        Feedback feedback = dummyFeedback();
        feedbackRequest.setId(feedback.getId());
        feedbackRequest.setName(feedback.getName());
        feedbackRequest.setEmail(feedback.getEmail());
        feedbackRequest.setSuggestion(feedback.getSuggestion());
        feedbackRequest.setScale(feedback.getScale());
        feedbackRequest.setComments(feedback.getComments());
        feedbackRequest.setDelete(false);
        return feedbackRequest;
    }

    @Test
    public void test_getById() {
        Integer id = 1;
        Optional<Feedback> feedback = feedbackService.getById(id);
        when(feedbackService.getById(id)).thenReturn(feedback);
        Optional<Feedback> response = feedbackController.getById(id);
        assertNotNull(response);

    }

    @Test
    public void test_deleteById() {
        Integer id = 1;
        String res = "Feedback deleted Successfully";
        Feedback feedback = dummyFeedback();
        feedback.setDelete(true);
        when(feedbackService.deleteById(id)).thenReturn(res);
        String response = feedbackController.deleteById(id);
        assertNotNull(response);

    }

    @Test
    public void test_updateFeedback() {
        Integer id = 1;
        Feedback feedback = dummyFeedback();
        FeedbackDto feedbackRequest = dummyFeedbackRequest();
        when(feedbackService.updateFeedback(id, feedback)).thenReturn(feedback);
        Object response = feedbackController.updateFeedback(id, feedback);
        assertNotNull(response);

    }

    @Test
    public void test_allFeedback() {
        Feedback feedback = dummyFeedback();
        List<Feedback> list = new ArrayList<>();
        list.add(feedback);
        when(feedbackService.allFeedback()).thenReturn(list);
        List<Feedback> response = feedbackController.allFeedback();
        assertNotNull(response);

    }

    @Test
    public void test_delete1() {
        Integer id = 1;
        Feedback feedback = dummyFeedback();
        Feedback response = dummyFeedback();
        feedbackService.deleteFeedback(id);
        feedbackController.deleteFeedback1(id);
        assertNotNull(response);

    }

    @org.junit.jupiter.api.Test
    public void test_allOwnerFeedback(){
        List<Map<String, String>> feedback=feedbackRepository.findAllOwnerFeedback();
        when(feedbackRepository.findAllOwnerFeedback()).thenReturn(feedback);
        List<Map<String, String>> response=feedbackController.allOwnerFeedback();
        assertNotNull(response);
    }
}
