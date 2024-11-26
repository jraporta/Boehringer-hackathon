package com.ironhackers.ppg.controller;

import com.ironhackers.ppg.model.Diagnose;
import com.ironhackers.ppg.model.Patient;
import com.ironhackers.ppg.service.DiagnoseService;
import com.ironhackers.ppg.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiagnoseContoller {

    @Autowired
    private PatientService patientService;

    @Autowired
    private DiagnoseService diagnoseService;

    @GetMapping("/api/patients/{id}/iadiagnose")
    public ResponseEntity<Diagnose> getDiagnose(@PathVariable Long id){
        Patient patient = patientService.getPatient(id);
        return ResponseEntity.ok(diagnoseService.getDiagnose(patient));
    }

}
