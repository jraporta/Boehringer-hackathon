package com.ironhackers.ppg.controller;

import com.ironhackers.ppg.model.Symptom;
import com.ironhackers.ppg.service.SymptomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SymptomController {

    @Autowired
    private SymptomService symptomService;

    @PostMapping("/api/symptoms")
    public ResponseEntity<String> createSymptom(@RequestBody Symptom symptom){
        Symptom createdSymptom = symptomService.createSymptom(symptom);
        return ResponseEntity.ok("Added symptom with id: " + createdSymptom.getId());
    }

    @GetMapping("/api/symptoms/{id}")
    public ResponseEntity<Symptom> getSymptom(@PathVariable Long id){
        return ResponseEntity.ok(symptomService.getSymptom(id));
    }

    @GetMapping("/api/symptoms")
    public ResponseEntity<List<Symptom>> getSymptoms(){
        return ResponseEntity.ok(symptomService.getSymptoms());
    }

    @PostMapping("/api/symptoms/import")
    public ResponseEntity<String> importSymptoms(@RequestBody List<Symptom> symptoms){
        return ResponseEntity.ok("Added " + symptomService.importSymptoms(symptoms) + " symptoms to the Db");
    }
}
