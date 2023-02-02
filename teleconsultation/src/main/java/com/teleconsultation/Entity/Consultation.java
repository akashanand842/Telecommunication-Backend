package com.teleconsultation.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long consultationId;
    private String date;
    private String time;
    @ManyToMany(
            cascade = CascadeType.ALL
    )
    @JoinTable(
            name = "patient_consultation_map",
            joinColumns = @JoinColumn(
                    name = "consultation_id",
                    referencedColumnName = "consultationId"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "patient_id",
                    referencedColumnName = "patientId"
            )
    )
    private List<Patient> patientList;
    @ManyToMany(
            cascade = CascadeType.ALL
    )
    @JoinTable(
            name = "doctor_consultation_map",
            joinColumns = @JoinColumn(
                    name = "consultation_id",
                    referencedColumnName = "consultationId"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "doctor_id",
                    referencedColumnName = "doctorId"
            )
    )
    private List<Doctor> doctorList;
    String type;


}
