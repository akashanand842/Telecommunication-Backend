package com.teleconsultation.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DoctorController {
    //login
    @GetMapping("/login/doctor")
    public boolean login(){

        return true;
    }
    //
}
