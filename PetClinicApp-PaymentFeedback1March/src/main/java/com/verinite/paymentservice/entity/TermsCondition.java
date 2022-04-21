package com.verinite.paymentservice.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name="tbl_termcondition")
public class TermsCondition {
    @Id
    private String term1;
    private String term2;
    private String term3;

}