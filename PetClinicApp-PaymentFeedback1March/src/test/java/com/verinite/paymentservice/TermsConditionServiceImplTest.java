package com.verinite.paymentservice;


import com.verinite.paymentservice.dto.TermsConditionDto;
import com.verinite.paymentservice.entity.TermsCondition;
import com.verinite.paymentservice.repository.TermsRepository;
import com.verinite.paymentservice.service.TermsServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
@DataJpaTest
public class TermsConditionServiceImplTest {
    @Mock
    TermsRepository termsRepository;
    @InjectMocks
    TermsServiceImpl termsServiceimpl;

    @Test
    public void test_insertTermsCondition(){
        TermsCondition terms = dummyTermsCondition();

        TermsConditionDto termsConditionDto= dummyTermsConditionDto();
        when(termsRepository.save(terms)).thenReturn(terms);
        TermsCondition response = termsServiceimpl.insertTerms(terms);
        assertNotNull(response);

    }
    TermsCondition dummyTermsCondition(){
        TermsCondition terms = new TermsCondition();
        terms.setTerm1("hiii");
        terms.setTerm2("helllo");
        terms.setTerm3("nooo");
        return terms;
    }
    TermsConditionDto dummyTermsConditionDto(){
        TermsConditionDto termsConditionDto = new TermsConditionDto();
        TermsCondition terms = dummyTermsCondition();
        termsConditionDto.setTerm1(terms.getTerm1());
        termsConditionDto.setTerm2(terms.getTerm2());
        termsConditionDto.setTerm3(terms.getTerm3());
        return termsConditionDto;
    }
    @Test
    public void test_getAll(){
        TermsCondition terms = dummyTermsCondition();
        TermsConditionDto termsConditionDto= dummyTermsConditionDto();

        List<TermsCondition> list = new ArrayList<>();
        list.add(terms);
        when(termsRepository.findAll()).thenReturn(list);
        List<TermsCondition> response = termsServiceimpl.allTerms();
        assertNotNull(response);
    }
}