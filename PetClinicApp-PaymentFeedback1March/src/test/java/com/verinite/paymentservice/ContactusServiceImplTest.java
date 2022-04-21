package com.verinite.paymentservice;


import com.verinite.paymentservice.dto.ContactUsDto;
import com.verinite.paymentservice.entity.ContactUs;
import com.verinite.paymentservice.repository.ContactRepository;
import com.verinite.paymentservice.service.ContactserviceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
@DataJpaTest
public class ContactusServiceImplTest {
    @Mock
    ContactRepository contactRepository;
    @InjectMocks
    ContactserviceImpl contactserviceImpl;

    @Test
    public void test_insertContactUs(){
        ContactUs contact = dummyContactUs();
        ContactUsDto contactUsDto = dummyContactUsDto();
        when(contactRepository.save(contact)).thenReturn(contact);
        ContactUs response = contactserviceImpl.insertContact(contact);
        assertNotNull(response);
    }

    @Test
    public void test_allContact(){
        ContactUs contactUs = dummyContactUs();
        List<ContactUs> contactUses = contactRepository.findAll();
        when(contactRepository.findAll()).thenReturn(contactUses);
        List<ContactUs> response = contactserviceImpl.allContact();
        assertNotNull(response);
    }

    ContactUs dummyContactUs(){
        ContactUs contact = new ContactUs();
        contact.setId(1);
        contact.setName("jayshri");
        contact.setEmail("j@gmail.com");
        contact.setMessage("hiii");
        contact.setSubject("no subject");
        return contact;
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