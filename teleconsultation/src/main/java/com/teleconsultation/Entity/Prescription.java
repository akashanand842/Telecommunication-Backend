package com.teleconsultation.Entity;

import javax.persistence.*;

@Entity
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long prescriptionId;

    private String medicineName;
    private String dosage;
    private String duration;
    @ManyToOne(

    )
    @JoinColumn(
            name = "patient_id"

    )
    private Patient patient;

}
