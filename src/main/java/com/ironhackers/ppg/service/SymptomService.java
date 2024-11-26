package com.ironhackers.ppg.service;

import com.ironhackers.ppg.exceptions.custom.EntityNotFoundException;
import com.ironhackers.ppg.exceptions.custom.SymptomAlreadyExistsException;
import com.ironhackers.ppg.model.Symptom;
import com.ironhackers.ppg.repository.SymptomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class SymptomService {

    @Autowired
    private SymptomRepository symptomRepository;

    public Symptom createSymptom(Symptom symptom) {
        if (symptomRepository.findByName(symptom.getName()).isPresent()) {
            throw new SymptomAlreadyExistsException("There is already a symptom with this name.");
        }
        return symptomRepository.save(symptom);
    }

    public Symptom getSymptom(Long id) {
        return symptomRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("No symptom found with id " + id)
        );
    }

    public List<Symptom> getSymptoms() {
        return symptomRepository.findAll();
    }

    public long importSymptoms(List<Symptom> symptoms) {
        AtomicInteger count = new AtomicInteger();
        symptoms.forEach(symptom -> {
            try {
                createSymptom(symptom);
                count.getAndIncrement();
            }catch (SymptomAlreadyExistsException e){

            }
        });
        return count.get();
    }
}
