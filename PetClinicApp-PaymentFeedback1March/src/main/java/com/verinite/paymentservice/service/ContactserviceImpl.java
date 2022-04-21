package com.verinite.paymentservice.service;

import java.util.List;

import com.verinite.paymentservice.entity.ContactUs;
import com.verinite.paymentservice.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ContactserviceImpl implements ContactService {
    @Autowired
    ContactRepository contactRepository;
    @Override
    public ContactUs insertContact(ContactUs contactus) {

        contactus.setEmail(contactus.getEmail());
        contactus.setName(contactus.getName());
        contactus.setSubject(contactus.getSubject());
        contactus.setMessage(contactus.getMessage());

        //	feedback.setDelete(false);
        return contactRepository.save(contactus);
    }

    @Override
    public List<ContactUs> allContact() {
        // TODO Auto-generated method stub
        return contactRepository.findAll();
    }

}
