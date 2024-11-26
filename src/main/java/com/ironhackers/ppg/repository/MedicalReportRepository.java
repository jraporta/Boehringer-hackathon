package com.ironhackers.ppg.repository;

import com.ironhackers.ppg.model.MedicalReport;
import com.ironhackers.ppg.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicalReportRepository extends JpaRepository<MedicalReport, Long> {

    List<MedicalReport> findAllByPatient(Patient patient);

}
