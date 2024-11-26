package com.ironhackers.ppg.repository;

import com.ironhackers.ppg.model.Symptom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SymptomRepository extends JpaRepository<Symptom, Long> {

    Optional<Symptom> findByName(String name);

}
