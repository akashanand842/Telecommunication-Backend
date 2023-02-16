package com.teleconsultation.Controller;

import com.teleconsultation.Entity.Doctor;
import com.teleconsultation.Entity.HealthRecord;
import com.teleconsultation.Entity.Patient;
import com.teleconsultation.Entity.Prescription;
import com.teleconsultation.Model.PrescriptionModel;
import com.teleconsultation.Repository.DoctorRepository;
import com.teleconsultation.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/doctor")
public class DoctorController {
    //login
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private HealthRecordService healthRecordService;
    @Autowired
    private PrescriptionService prescriptionService;
    @Autowired
    private PatientService patientService;
    @Autowired
    private QueueService queueService;
//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public boolean login(Doctor doctor){
        if(doctorService.doctorLogin(doctor)){
            return true;
        }
        return false;
    }

    //after adding doctor initially he is not in queue. so statusQueue = false
    @PostMapping("/add")
    public Doctor addDoctor(@RequestBody Doctor doctor){
        Doctor doctor1 = Doctor.builder()
                .doctorName(doctor.getDoctorName())
                .contact(doctor.getContact())
                .emailId(doctor.getEmailId())
                .password(doctor.getPassword())
                .statusQueue(false)
                .build();
        return doctorService.addDoctor(doctor1);

    }

    @GetMapping("/view")
    public List<Doctor> viewDoctor(){
        return doctorService.viewDoctor();
    }

    @PostMapping("/joinqueue")
    public void joinQueue(Doctor doctor){
        // if already in queue return false
        queueService.addDoctorToQueue(doctor);
    }
    @GetMapping("/view/healthrecord/{patientId}")
    private HealthRecord viewHealthRecord(@PathVariable("patientId") Long patientId){
        return healthRecordService.viewHealthRecord(patientId);
    }
    @PostMapping("/add/prescription/{patientId}/{doctorId}")
    public ResponseEntity<Boolean> addPrescription(@PathVariable Long patientId, @PathVariable Long doctorId, @RequestBody PrescriptionModel prescriptionModel){
        Prescription prescription = Prescription.builder()
                .medicalFinding(prescriptionModel.getMedicalFinding())
                .dosage(prescriptionModel.getDosage())
                .medicineName(prescriptionModel.getMedicineName())
                .duration(prescriptionModel.getDuration())
                .doctor(doctorService.getDoctorById(doctorId))
                .patient(patientService.getPatientById(patientId))
                .build();
        Prescription createdPrescription = prescriptionService.add(prescription);
        return ResponseEntity.status(HttpStatus.CREATED).body(true);
    }

}
