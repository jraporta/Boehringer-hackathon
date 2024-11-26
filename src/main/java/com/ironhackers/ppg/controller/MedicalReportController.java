package com.ironhackers.ppg.controller;

import com.ironhackers.ppg.model.MedicalReport;
import com.ironhackers.ppg.model.Patient;
import com.ironhackers.ppg.service.MedicalReportService;
import com.ironhackers.ppg.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MedicalReportController {

    @Autowired
    private MedicalReportService medicalReportService;

    @Autowired
    private PatientService patientService;

    @PostMapping("/api/patients/{id}/medicalreports")
    public ResponseEntity<String> createMedicalReport(@PathVariable Long id, @RequestBody MedicalReport medicalReport){
        Patient patient = patientService.getPatient(id);
        medicalReport.setPatient(patient);
        MedicalReport savedReport= medicalReportService.createMedicalReport(medicalReport);
        return ResponseEntity.ok("Added Medical Report with id: " + savedReport.getId());
    }

    @GetMapping("/api/medicalreports/{id}")
    public ResponseEntity<MedicalReport> getMedicalReport(@PathVariable Long id){
        return ResponseEntity.ok(medicalReportService.getMedicalReport(id));
    }

    @GetMapping("/api/patients/{id}/medicalreports")
    public ResponseEntity<List<MedicalReport>> getPatients(@PathVariable Long id){
        Patient patient = patientService.getPatient(id);
        return ResponseEntity.ok(medicalReportService.getMedicalReports(patient));
    }

}
