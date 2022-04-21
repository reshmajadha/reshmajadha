package com.verinite.paymentservice.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PrescriptionDto {


    private Integer prescriptionId;
    private  String medicineName;
    private String doses;
    private  Integer quantity;
    private  String instructions;

}
