package com.verinite.paymentservice.dto;

import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class petvisit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int pet_id;
    private Date date;
    private String description;
    private boolean isd_delete;

    private String pet_name;
    private String owner_name;
    private int species_id;
    private String pet_species;
    private String pet_symptoms;
    // private boolean is_delete;
    private int visit_id;
}
