package com.verinite.paymentservice.service;

import com.verinite.paymentservice.entity.Payments;

import com.verinite.paymentservice.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;



    public Payments doPayment(Payments payments){
        payments.setDoctorFee(200);
        payments.setPaymentStatus(paymentProcessing());
        payments.setTransactionId(UUID.randomUUID().toString());
        return paymentRepository.save(payments);
    }

    public String paymentProcessing(){
        //api should be third party payment gateway
        return new Random().nextBoolean()?"sucess":"false";
    }
    public Payments getPaymentId (int id){
        return paymentRepository.findById(id).get();

    }
	
	public List<Payments> allPayment() {
		return paymentRepository.findAll();
	}
	public Object updatePayment(int id, Payments payments) {
		// TODO Auto-generated method stub
		return paymentRepository.save(payments) ;
	}
	
	public String deleteById(int id) {
		// TODO Auto-generated method stub
		 paymentRepository.deleteById(id);
		 return "Record deleted Successfully";
	}
    public String deleteById1(int paymentId) {
        try {
            Payments payments = paymentRepository.findById(paymentId).get();
            if (!payments.isDelete()) {
                payments.setDelete(true);
                paymentRepository.save(payments);

                return "payments record Successfully deleted";
            } else {
                return "Given paymentId is already deleted";
            }
        } catch (Exception e) {
            return "Id not Found";
        }

    }

    public List<Payments> listAll() {
        List<Payments> payments = paymentRepository.findAll();
        return  payments;
    }
}

