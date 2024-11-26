package com.ironhackers.ppg.controller;

import com.ironhackers.ppg.dto.PatientDto;
import com.ironhackers.ppg.model.Patient;
import com.ironhackers.ppg.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping("/api/patients")
    public ResponseEntity<String> createPatient(@RequestBody Patient patient){
        Patient createdPatient = patientService.createPatient(patient);
        return ResponseEntity.ok("Added patient with id: " + createdPatient.getId());
    }

    @GetMapping("/api/patients/{id}")
    public ResponseEntity<Patient> getPatient(@PathVariable Long id){
        return ResponseEntity.ok(patientService.getPatient(id));
    }

    @GetMapping("/api/patients")
    public ResponseEntity<List<Patient>> getPatients(){
        return ResponseEntity.ok(patientService.getPatients());
    }

    @DeleteMapping("/api/patients/{id}")
    public ResponseEntity<Patient> deletePatient(@PathVariable Long id){
        patientService.deletePatient(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/api/patients")
    public ResponseEntity<Patient> updatePatient(@RequestBody PatientDto patient){
        return ResponseEntity.ok(patientService.updatePatient(patient));
    }
}
