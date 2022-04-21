package com.verinite.paymentservice.service;

import com.verinite.paymentservice.entity.TermsCondition;

import java.util.List;


public interface TermsService {

    TermsCondition insertTerms(TermsCondition termsCondition);

    List<TermsCondition> allTerms();

}