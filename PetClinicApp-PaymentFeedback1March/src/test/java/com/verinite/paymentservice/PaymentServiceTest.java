package com.verinite.paymentservice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;


import com.verinite.paymentservice.dto.PaymentRequest;
import com.verinite.paymentservice.entity.Payments;
import com.verinite.paymentservice.repository.PaymentRepository;
import com.verinite.paymentservice.service.PaymentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@SpringBootTest
public class PaymentServiceTest {
    //	@MockBean
//	PaymentRepository paymentRepository;
//	@Autowired
//	PaymentService paymentService;
    PaymentRequest paymentRequest = new PaymentRequest();
    Payments payments = new Payments();


    @Autowired
    private PaymentService paymentService;

    @MockBean
    private PaymentRepository paymentRepository;

    @Test
    public void getUsersTest() {
        when(paymentRepository.findAll()).thenReturn(Stream
                .of(new Payments(1, "Success", "ud52663", 500, "765752hh76", "Bkid", "BOI", "Pune", "Jagruti",false),
                        new Payments(2, "Success", "hj345436", 1500, "hgh32532552", "HDFC00123", "HDFC", "Latur", "Jayshree", false)).collect(Collectors.toList()));
        assertEquals(2, paymentService.allPayment().size());
    }

    @Test
    public void saveUserTest() {
        Payments payments = new Payments(3, "Success", "ghh24", 1500, "hgh32532552", "HDFC00123", "HDFC", "Latur", "Reshma",false);
        when(paymentRepository.save(payments)).thenReturn(payments);
        assertEquals(payments, paymentService.doPayment(payments));
    }

//	@Test
//	public void deleteUserTest() {
//		Payments payments = new Payments(1, "Success", "ud52663", 500, "765752hh76", "Bkid", "BOI", "Pune", "Jagruti");
//		paymentService.deleteById(payments.getPaymentId());
//		verify(paymentRepository, times(1)).delete(payments);
//
//	}

    @Test
    public void UpdateUserTest() {
        Payments payments = new Payments(1, "Success", "ud52663", 500, "765752hh76", "Bkid", "BOI", "Pune", "Jagruti",false);
        Integer id = 1;
        Payments payments1 = new Payments();
        when(paymentRepository.findById(id)).thenReturn(Optional.ofNullable(payments1));
        Payments response = paymentRepository.save(payments1);
        paymentService.updatePayment(id, payments);
    }
    @Test
    public void testGetById(){
        Payments payments1 = new Payments();
        Integer id =1;
        when(paymentRepository.findById(1)).thenReturn(Optional.ofNullable(payments1));
        paymentRepository.getById(id);
        when(paymentRepository.getById(1)).thenReturn(payments1);
        Object response = paymentService.getPaymentId(1);
        assertNotNull(response);
    }
    @Test
    public void deleteById1(){
        Payments payments1 = new Payments();
        Integer id =1;
        paymentRepository.deleteById(id);
        paymentService.deleteById(id);
        assertNotNull(paymentRepository);
    }
}





