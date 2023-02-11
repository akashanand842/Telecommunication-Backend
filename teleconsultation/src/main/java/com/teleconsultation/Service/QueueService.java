package com.teleconsultation.Service;

import com.teleconsultation.Entity.Doctor;
import com.teleconsultation.Entity.Patient;
import org.springframework.stereotype.Service;

import java.util.Queue;


public interface QueueService {


    public void addPatientToQueue(Patient patient);

    public void leavePatientQueue(Patient patient);
    public void addDoctorToQueue(Doctor doctor);
    public void leaveDoctorQueue(Doctor doctor);
    public Patient getNextPatient();
    public Doctor getNextAvailableDoctor();
}
