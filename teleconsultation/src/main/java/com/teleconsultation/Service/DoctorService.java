package com.teleconsultation.Service;

import com.teleconsultation.Entity.Doctor;
import com.teleconsultation.Entity.Patient;
import com.teleconsultation.Entity.Prescription;
import com.teleconsultation.Repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface DoctorService {
    public boolean doctorLogin(Doctor doctor);
    public Doctor addDoctor(Doctor doctor);

    public void scheduleFollowUp(Patient patient);
    public Prescription issuePrescription(Patient patient);
    public List<Patient> viewFollowUp();
    public void cancelFollowUp(Patient patient);
}
