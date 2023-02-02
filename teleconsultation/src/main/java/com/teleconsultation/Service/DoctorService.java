package com.teleconsultation.Service;

import com.teleconsultation.Entity.Doctor;
import com.teleconsultation.Repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;
    public boolean isAllowed(Doctor doctor) {
        return true;
    }
}
