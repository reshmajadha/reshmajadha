package com.verinite.paymentservice.service;


import com.verinite.paymentservice.entity.Payments;

public class invoice {

    Payments payments = new Payments();


    public String invoiceNumber(int customerName){
        String invoic = "INV0000"+ customerName;
        return  invoic;
    }


}