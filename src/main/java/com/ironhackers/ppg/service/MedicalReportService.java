package com.ironhackers.ppg.service;

import com.ironhackers.ppg.exceptions.custom.EntityNotFoundException;
import com.ironhackers.ppg.model.MedicalReport;
import com.ironhackers.ppg.model.Patient;
import com.ironhackers.ppg.repository.MedicalReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalReportService {

    @Autowired
    private MedicalReportRepository medicalReportRepository;

    public MedicalReport createMedicalReport(MedicalReport medicalReport) {
        return medicalReportRepository.save(medicalReport);
    }

    public MedicalReport getMedicalReport(Long id) {
        return medicalReportRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("No Medical Report found with id " + id)
        );
    }

    public List<MedicalReport> getMedicalReports(Patient patient) {
        return medicalReportRepository.findAllByPatient(patient);
    }

}
