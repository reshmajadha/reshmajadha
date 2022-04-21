package com.verinite.paymentservice;


import com.verinite.paymentservice.controller.ContactController;
import com.verinite.paymentservice.dto.ContactUsDto;
import com.verinite.paymentservice.entity.ContactUs;
import com.verinite.paymentservice.service.ContactService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class ContactUsControllerTest {
    @Mock
    ContactService contactService;
    @InjectMocks
    ContactController contactController;

    @Test
    public void test_contactUsInsert(){
        ContactUs contactus = dummyContactUs();
        ContactUsDto contactUsDto = dummyContactUsDto();
        when(contactService.insertContact(contactus)).thenReturn(contactus);
        ContactUs response = contactController.insertContact(contactus);
        assertNotNull(response);
    }

    @Test
    public void test_allContact(){
        List<ContactUs> contactUses = contactService.allContact();
        when(contactService.allContact()).thenReturn(contactUses);
        List<ContactUs> response = contactController.allContact();
        assertNotNull(response);
    }
    ContactUs dummyContactUs(){
        ContactUs contactus = new ContactUs();
        contactus.setId(1);
        contactus.setName("jayshri");
        contactus.setEmail("j@gmail.com");
        contactus.setMessage("hiii");
        contactus.setSubject("no subject");
        return contactus;
    }
    ContactUsDto dummyContactUsDto(){
        ContactUsDto contactUsDto= new ContactUsDto();
        ContactUs contactus= dummyContactUs();
        contactUsDto.setId(contactus.getId());
        contactUsDto.setName(contactus.getName());
        contactUsDto.setEmail(contactus.getMessage());
        contactUsDto.setSubject(contactus.getSubject());
        return contactUsDto;
    }
}
