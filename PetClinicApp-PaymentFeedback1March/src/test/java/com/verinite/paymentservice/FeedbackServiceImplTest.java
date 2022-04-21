package com.verinite.paymentservice;


import com.verinite.paymentservice.dto.FeedbackDto;
import com.verinite.paymentservice.entity.Feedback;
import com.verinite.paymentservice.repository.FeedbackRepository;
import com.verinite.paymentservice.service.FeedbackServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;


@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
@DataJpaTest
public class FeedbackServiceImplTest {
    @Mock
    FeedbackRepository feedbackRepository;

    @InjectMocks
    FeedbackServiceImpl feedbackServiceImpl;


    // FeedbackDto feedbackRequest = new FeedbackDto();

    @Test
    public void test_insertFeedback() {
        Feedback feedback = dummyFeedback();
        FeedbackDto feedbackRequest = dummyFeedbackRequest();
        when(feedbackRepository.save(feedback)).thenReturn(feedback);
        Feedback response = feedbackServiceImpl.insertFeedback(feedback);
        assertNotNull(response);

    }

    Feedback dummyFeedback() {
        Feedback feedback = new Feedback();
        feedback.setId(1);
        feedback.setDelete(false);
        feedback.setComments("hiii");
        feedback.setSuggestion("no");
        feedback.setEmail("sap@gmail.com");
        feedback.setScale(1);
        feedback.setName("jayu");
        return feedback;
    }

    FeedbackDto dummyFeedbackRequest() {
        FeedbackDto feedbackRequest = new FeedbackDto();
        feedbackRequest.setId(feedbackRequest.getId());
        feedbackRequest.setName(feedbackRequest.getName());
        feedbackRequest.setEmail(feedbackRequest.getEmail());
        feedbackRequest.setSuggestion(feedbackRequest.getSuggestion());
        feedbackRequest.setScale(feedbackRequest.getScale());
        feedbackRequest.setComments(feedbackRequest.getComments());
        feedbackRequest.setDelete(false);
        return feedbackRequest;
    }

    @Test
    public void test_getById() {
        Feedback feedback = dummyFeedback();
        Integer id = 1;

        feedbackRepository.findById(id);
        Optional<Feedback> response = feedbackServiceImpl.getById(id);
        assertNotNull(feedback);
        assertNotNull(response);

    }



    @Test
    public void test_updateFeedback() {
        Integer id = 1;
        Feedback feedback = dummyFeedback();
        Feedback res=dummyFeedback();
        when(feedbackRepository.getById(id)).thenReturn(res);
        res=  feedbackRepository.save(res);
        feedbackServiceImpl.updateFeedback(id,feedback);


    }
    @Test
    public void test_updateIdNotPresent(){
        Integer id = 4;
        Feedback feedback = dummyFeedback();
        feedbackRepository.getById(id);
        Object response = feedbackServiceImpl.updateFeedback(id, feedback);
        assertNotNull(response);
        assertNotNull("Id For Update Not Present",response);
    }


    @Test
    public void test_deleteById(){
        Feedback feedback = dummyFeedback();

        Integer id = 1;
        when(feedbackRepository.getById(id)).thenReturn(feedback);
        String response = feedbackServiceImpl.deleteById(id);
        assertNotNull(response);
    }
    @Test
    public void test_deleteAlready(){
        Feedback feedback = dummyFeedback();
        feedback.setDelete(true);
        Integer id = 6;
        when(feedbackRepository.getById(id)).thenReturn(feedback);
        String response = feedbackServiceImpl.deleteById(id);
        assertNotNull( "Feedback Already deleted", response);
    }
    @Test
    public void test_deleteIdNotPresent(){
        Integer id=3;
        feedbackRepository.getById(id);
        String response = feedbackServiceImpl.deleteById(id);
        assertNotNull(response);
        assertNotNull("Id Not present" , response);
    }
    @Test
    public void test_allFeedback(){
        Feedback feedback = dummyFeedback();
        List<Feedback> list = new ArrayList<>();
        list.add(feedback);
        when(feedbackRepository.findAll()).thenReturn(list);
        List<Feedback> response = feedbackServiceImpl.allFeedback();
        assertNotNull(response);
    }
    @Test
    public void test_delete1(){
        Feedback feedback = dummyFeedback();
        Integer id=1;
        feedbackRepository.deleteById(id);
        feedbackServiceImpl.deleteFeedback(id);
        assertNotNull(feedback);
    }

}
