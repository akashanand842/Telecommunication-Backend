package com.teleconsultation.Service;

import com.teleconsultation.Entity.Patient;
import com.teleconsultation.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService{
    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private QueueService queueService;
    @Override
    public boolean patientLogin(Patient patient) {
        return false;
    }

    @Override
    public void joinQueue(Patient patient) {
        queueService.addPatientToQueue(patient);
    }

    @Override
    public Patient getPatientById(Long patientId) {
        return patientRepository.findById(patientId).get();
    }
}
