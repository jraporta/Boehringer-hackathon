package com.ironhackers.ppg.service;

import com.ironhackers.ppg.dto.PatientDto;
import com.ironhackers.ppg.exceptions.custom.MissingIdException;
import com.ironhackers.ppg.exceptions.custom.EntityNotFoundException;
import com.ironhackers.ppg.model.Patient;
import com.ironhackers.ppg.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> getPatients() {
        return patientRepository.findAll();
    }

    public Patient getPatient(Long id) {
        return patientRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("No patient found with id " + id)
        );
    }

    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public void deletePatient(Long id) {
        Patient patient = getPatient(id);
        patientRepository.deleteById(id);
    }

    public Patient updatePatient(PatientDto patientData) {
        Long id = patientData.getId();
        if (id == null) throw new MissingIdException("Patient's id is a mandatory field.");
        Patient patient = getPatient(id);
        if (patientData.getName() != null) patient.setName(patientData.getName());
        if (patientData.getAge() != null) patient.setAge(patientData.getAge());
        if (patientData.getGender() != null) patient.setGender(patientData.getGender());
        return patientRepository.save(patient);
    }
}
