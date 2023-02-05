package com.teleconsultation.Service;

import com.teleconsultation.Entity.Doctor;
import com.teleconsultation.Entity.Patient;

public interface ConsultationService {

    void startConsultation(Doctor doctor, Patient patient);
}
