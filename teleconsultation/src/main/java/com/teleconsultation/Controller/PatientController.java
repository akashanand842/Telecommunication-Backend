package com.teleconsultation.Controller;

import com.teleconsultation.Entity.Patient;
import com.teleconsultation.Entity.Prescription;
import com.teleconsultation.Service.FileService;
import com.teleconsultation.Service.PatientService;
import com.teleconsultation.Service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.processing.Generated;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    private PatientService patientService;
    @Autowired
    private PrescriptionService prescriptionService;
    @Autowired
    private FileService fileService;
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

    // Theek karna hai prescription ko
    @GetMapping("/prescription/{patientId}/{doctorId}")
    public ResponseEntity<byte[]> downloadPrescription(@PathVariable Long patientId, @PathVariable Long doctorId) {
        Prescription prescription = prescriptionService.searchByPatientAndDoctor(patientId, doctorId);
        byte[] pdfFile = fileService.generatePdfFile(prescription);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentLength(pdfFile.length);
        headers.setContentDispositionFormData("attachment", "prescription.pdf");
        return ResponseEntity.ok().headers(headers).body(pdfFile);
    }

}
