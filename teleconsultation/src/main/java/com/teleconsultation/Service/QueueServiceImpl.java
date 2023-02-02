package com.teleconsultation.Service;

import com.teleconsultation.Entity.Doctor;
import com.teleconsultation.Entity.Patient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Queue;

@Service
public class QueueServiceImpl implements QueueService{
    private Queue<Patient> patientWaiting;
    private Queue<Doctor> availableDoctors;
}
