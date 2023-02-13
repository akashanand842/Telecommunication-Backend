package com.teleconsultation.Service;

import com.teleconsultation.Entity.Prescription;
import org.springframework.stereotype.Service;

@Service
public interface PrescriptionService {

    public void add(Prescription prescription);

    Prescription searchByPatientAndDoctor(Long patientId, Long doctorId);
}
