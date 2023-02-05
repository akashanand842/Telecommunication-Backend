package com.teleconsultation.Controller;

import com.teleconsultation.Entity.Patient;
import com.teleconsultation.Entity.Prescription;
import com.teleconsultation.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.processing.Generated;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    private PatientService patientService;

    // Patient joins the Queue so set status = true.
    @PostMapping("/joinqueue")
    public boolean joinQueue(Patient patient){
        //if patient already in queue
        if(patient.isStatusQueue()) {
            return false;
        }
        patient.setStatusQueue(true);
        patientService.joinQueue(patient);
        return true;
    }

    @PostMapping ("/pres")
    public Prescription getPrescription(@RequestBody Patient patient){
        return null;
    }

}
