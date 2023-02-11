package com.teleconsultation.Controller;

import com.teleconsultation.Entity.Doctor;
import com.teleconsultation.Entity.Patient;
import com.teleconsultation.Entity.Prescription;
import com.teleconsultation.Model.PrescriptionModel;
import com.teleconsultation.Repository.DoctorRepository;
import com.teleconsultation.Service.DoctorService;
import com.teleconsultation.Service.PatientService;
import com.teleconsultation.Service.QueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/doctor")
public class DoctorController {
    //login
    @Autowired
    private DoctorService doctorService;

    @Autowired
    private PatientService patientService;
    @Autowired
    private QueueService queueService;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public boolean login(Doctor doctor){
        if(doctorService.doctorLogin(doctor)){
            return true;
        }
        return false;
    }

    //after adding doctor initially he is not in queue. so statusQueue = false
    @PostMapping("/add/doctor")
    public Doctor addDoctor(Doctor doctor){
        Doctor doctor1 = Doctor.builder()
                .doctorName(doctor.getDoctorName())
                .contact(doctor.getContact())
                .emailId(doctor.getEmailId())
                .password(passwordEncoder.encode(doctor.getPassword()))
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

    @PostMapping("/add/prescription/{patientId}/{doctorId}")
    public void addPrescription(@PathVariable Long patientId, @PathVariable Long doctorId,@RequestBody PrescriptionModel prescriptionModel){
        Prescription prescription = Prescription.builder()
                .dosage(prescriptionModel.getDosage())
                .medicineName(prescriptionModel.getMedicineName())
                .duration(prescriptionModel.getDuration())
                .doctor(doctorService.getDoctorById(doctorId))
                .patient(patientService.getPatientById(patientId))
                .build();

    }

}
