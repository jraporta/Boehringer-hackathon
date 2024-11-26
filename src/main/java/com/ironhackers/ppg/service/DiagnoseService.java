package com.ironhackers.ppg.service;

import com.ironhackers.ppg.exceptions.custom.CantGenereteDiagnoseException;
import com.ironhackers.ppg.model.Diagnose;
import com.ironhackers.ppg.model.Patient;
import com.ironhackers.ppg.repository.DiagnoseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiagnoseService {

    @Autowired
    private DiagnoseRepository diagnoseRepository;

    public Diagnose getDiagnose(Patient patient) {
        if (patient.getMedicalReports().isEmpty()) {
            throw new CantGenereteDiagnoseException("The patient must have at least one Medical Record to generate the diagnose");
        }
        Diagnose diagnose = new Diagnose();
        diagnose.setConfidence(0.89);
        diagnose.setName("Probable PPG");
        diagnose.setPatient(patient);
        diagnose.setRecommendations(List.of("Evitar tomar el sol", "Hidratar con crema de Urea", "Medicamento XXX"));
        return diagnoseRepository.save(diagnose);
    }
}
