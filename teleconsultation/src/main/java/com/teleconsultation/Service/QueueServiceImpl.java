package com.teleconsultation.Service;

import com.teleconsultation.Entity.Doctor;
import com.teleconsultation.Entity.Patient;
import com.teleconsultation.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Queue;

@Service
public class QueueServiceImpl implements QueueService{
    private Queue<Patient> patientWaiting;
    private Queue<Doctor> availableDoctors;
    @Autowired
    private PatientRepository patientRepository;

    @Override
    public void addQueue(Patient patient) {
        patientWaiting.add(patient);
    }
}
