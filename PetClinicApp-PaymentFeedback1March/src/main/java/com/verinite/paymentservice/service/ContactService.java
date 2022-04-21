package com.verinite.paymentservice.service;

import com.verinite.paymentservice.entity.ContactUs;

import java.util.List;



public interface ContactService {

    ContactUs insertContact(ContactUs contactus);



    List<ContactUs> allContact();

}
