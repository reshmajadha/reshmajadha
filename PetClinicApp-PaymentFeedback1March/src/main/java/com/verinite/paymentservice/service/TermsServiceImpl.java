package com.verinite.paymentservice.service;

import java.util.List;

import com.verinite.paymentservice.entity.TermsCondition;
import com.verinite.paymentservice.repository.TermsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TermsServiceImpl implements TermsService{
    @Autowired
    TermsRepository termsRepository;

    @Override
    public TermsCondition insertTerms(TermsCondition termsCondition) {
        termsCondition.setTerm1(termsCondition.getTerm1());
        termsCondition.setTerm2(termsCondition.getTerm2());
        termsCondition.setTerm3(termsCondition.getTerm3());
        return termsRepository.save(termsCondition);
    }

    @Override
    public List<TermsCondition> allTerms() {

        return termsRepository.findAll();
    }


}