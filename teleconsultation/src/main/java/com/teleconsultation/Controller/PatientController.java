package com.teleconsultation.Controller;

import com.teleconsultation.Entity.Patient;
import com.teleconsultation.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    private PatientService patientService;

    // Patient joins the Queue so set status = true.
    @PostMapping("/joinqueue")
    public boolean joinQueue(Patient patient){
        if(patient.isStatusQueue()){
            patient.setStatusQueue(true);
            patientService.joinQueue(patient);
            return true;
        }
        return false;
    }
}
