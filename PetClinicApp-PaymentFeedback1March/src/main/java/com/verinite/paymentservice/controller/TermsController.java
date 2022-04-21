package com.verinite.paymentservice.controller;

import com.verinite.paymentservice.entity.TermsCondition;
import com.verinite.paymentservice.service.TermsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/terms")
public class TermsController {

    @Autowired
    TermsService termsService;
    @PostMapping("/save")
    public TermsCondition insertTerms(@RequestBody TermsCondition termsCondition) {
        return termsService.insertTerms(termsCondition);
    }

    @GetMapping("/getAll")
    public List<TermsCondition> allTerms() {
        return termsService.allTerms();
    }
}
