package com.verinite.paymentservice.entity;


import lombok.*;

import javax.persistence.*;
import java.util.Date;



@Table(name = "Pharmacy_Table")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pharmacy {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer medicine_id;
    private String medicine_name;
    private double price;
    private int quantity;
    private String description;
    private Date medicine_expiry_date;
    private int pet_id;

}