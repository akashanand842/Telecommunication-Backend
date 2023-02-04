package com.teleconsultation.Controller;

import com.teleconsultation.Entity.Doctor;
import com.teleconsultation.Repository.DoctorRepository;
import com.teleconsultation.Service.DoctorService;
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
    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public boolean login(Doctor doctor){
        if(doctorService.doctorLogin(doctor))
            return true;
        return false;
    }

    @PostMapping("/addDoctor")
    public Doctor addDoctor(Doctor doctor){
        Doctor doctor1 = Doctor.builder()
                .doctorName(doctor.getDoctorName())
                .contact(doctor.getContact())
                .emailId(doctor.getEmailId())
                .password(passwordEncoder.encode(doctor.getPassword()))
                .statusQueue(true)
                .build();
        return doctorService.addDoctor(doctor1);
    }

    @GetMapping("/viewDoctor")
    public List<Doctor> viewDoctor(){
        return doctorService.viewDoctor();
    }

    //
}
