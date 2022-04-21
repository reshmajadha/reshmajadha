package com.verinite.paymentservice.entity;



import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_petVisit")
public class PetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//	@Column(name = "pet_id")
    private int pet_id;

    //	@Column(name = "PetName")
    private String pet_name;

    //	@Column(name = "ownerName")
    private String owner_name;

    //	@Column(name = "species_id")
    private int species_id;

    //	@Column(name = "petSpecies")
    private String pet_species;

    //	@Column(name = "petSymptoms")
    private String pet_symptoms;

    //	@Column(name = "delete_Status")
    private boolean is_delete;

    //	@Column(name = "visit_id")
    private int visit_id;



}