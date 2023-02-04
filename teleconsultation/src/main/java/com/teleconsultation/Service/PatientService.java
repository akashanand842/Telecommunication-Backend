package com.teleconsultation.Service;

import com.teleconsultation.Entity.Patient;


public interface PatientService {
    public boolean patientLogin(Patient patient);

    void joinQueue(Patient patient);
}
