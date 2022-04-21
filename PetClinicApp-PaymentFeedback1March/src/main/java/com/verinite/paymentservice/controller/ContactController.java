package com.verinite.paymentservice.controller;

import java.util.List;

import com.verinite.paymentservice.entity.ContactUs;
import com.verinite.paymentservice.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/contact")
public class ContactController {
    @Autowired
    ContactService contactService;


    @PostMapping("/save")
    public ContactUs insertContact(@RequestBody ContactUs contactus) {
        return contactService.insertContact(contactus);
    }

    @GetMapping("/getAll")
    public List<ContactUs> allContact() {
        return contactService.allContact();
    }
}