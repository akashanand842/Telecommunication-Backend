package com.teleconsultation.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long doctorId;
    private String doctorName;
    private String contact;
    private String password;
    private String emailId;
    private String status;

}
