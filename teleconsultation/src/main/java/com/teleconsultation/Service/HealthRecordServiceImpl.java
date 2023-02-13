package com.teleconsultation.Service;

import com.teleconsultation.Entity.HealthRecord;
import com.teleconsultation.Repository.HealthRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HealthRecordServiceImpl implements HealthRecordService{
    @Autowired
    private HealthRecordRepository healthRecordRepository;
    @Override
    public HealthRecord viewHealthRecord(Long patientId) {
        return healthRecordRepository.findByPatientPatientId(patientId);
    }
}
