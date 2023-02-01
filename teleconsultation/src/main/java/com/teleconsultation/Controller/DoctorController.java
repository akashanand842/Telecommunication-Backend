package com.teleconsultation.Controller;

import com.teleconsultation.Entity.Doctor;
import com.teleconsultation.Repository.DoctorRepository;
import com.teleconsultation.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DoctorController {
    //login
    @Autowired
    private DoctorService doctorService;

    @GetMapping("/login/doctor}")
    public boolean login(Doctor doctor){
        if(doctorService.isAllowed(doctor))
            return true;
        return false;
    }


    //
}
