package com.teleconsultation.Service;

import com.teleconsultation.Entity.Doctor;
import com.teleconsultation.Entity.Patient;
import com.teleconsultation.Repository.DoctorRepository;
import com.teleconsultation.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.Queue;

@Service
public class QueueServiceImpl implements QueueService{
    private Queue<Patient> patientsQueue = new LinkedList<>();
    private Queue<Doctor> availableDoctors = new LinkedList<>();
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private ConsultationService consultationService;
    public void addPatientToQueue(Patient patient) {
        patient.setStatusQueue(true);
        patientsQueue.offer(patient);
    }

    @Override
    public void leavePatientQueue(Patient patient) {
        patient.setStatusQueue(false);
    }

    @Override
    public void addDoctorToQueue(Doctor doctor) {
        doctor.setStatusQueue(true);
        availableDoctors.offer(doctor);
    }

    @Override
    public void leaveDoctorQueue(Doctor doctor) {
        doctor.setStatusQueue(false);
    }

    @Override
    public Patient getNextPatient() {
        Patient patient = patientsQueue.poll();
        if(patient != null && patient.isStatusQueue()){
            patient.setStatusQueue(false);
            return patient;
        } else if (patient == null) {
            return null;
        }
        return getNextPatient();
    }

    @Override
    public Doctor getNextAvailableDoctor() {
        Doctor doctor = availableDoctors.poll();
        if(doctor != null && doctor.isStatusQueue()){
            doctor.setStatusQueue(false);
            return doctor;
        } else if (doctor == null) {
            return null;
        }
        return getNextAvailableDoctor();
    }
}
