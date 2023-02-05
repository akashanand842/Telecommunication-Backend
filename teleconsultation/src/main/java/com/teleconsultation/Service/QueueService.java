package com.teleconsultation.Service;

import com.teleconsultation.Entity.Doctor;
import com.teleconsultation.Entity.Patient;
import org.springframework.stereotype.Service;

import java.util.Queue;


public interface QueueService {


    void addQueuePatient(Patient patient);

    void addQueueDoctor(Doctor doctor);
    void setMeeting();
}
