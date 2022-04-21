package com.verinite.paymentservice.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="tbl_visiit")
@Setter
@Getter
@Data
public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int pet_id;
    private Date date;
    private String description;
    private boolean is_delete;


}
