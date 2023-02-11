package com.teleconsultation.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrescriptionModel {
    private String medicineName;
    private String dosage;
    private String duration;
}
