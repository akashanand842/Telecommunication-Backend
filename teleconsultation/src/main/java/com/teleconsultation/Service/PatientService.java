package com.teleconsultation.Service;

import com.teleconsultation.Entity.Patient;
import org.springframework.stereotype.Service;


public interface PatientService {
    public boolean patientLogin(Patient patient);
}
