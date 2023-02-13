package com.teleconsultation.Service;

import com.teleconsultation.Entity.Doctor;
import com.teleconsultation.Entity.Patient;
import com.teleconsultation.Entity.Prescription;
import com.teleconsultation.Repository.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PrescriptionServiceImpl implements PrescriptionService {
    @Autowired
    private PrescriptionRepository prescriptionRepository;

    @Autowired
    private DoctorService doctorService;
    @Autowired
    private PatientService patientService;
    @Override
    public void add(Prescription prescription) {
        prescriptionRepository.save(prescription);
    }

    //  Handle the Exception no doctor or no patient
    @Override
    public Prescription searchByPatientAndDoctor(Long patientId, Long doctorId) {
        Doctor doctor = doctorService.getDoctorById(doctorId);
        Patient patient = patientService.getPatientById(patientId);
        return prescriptionRepository.searchPrescriptionByDoctorAndPatient(doctor, patient);
    }
}
