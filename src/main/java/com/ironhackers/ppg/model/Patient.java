package com.ironhackers.ppg.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer age;

    private String gender;

    @OneToMany(mappedBy = "patient", cascade =  CascadeType.ALL, orphanRemoval = true)
    List<Diagnose> diagnoses = new ArrayList<>();

    @OneToMany(mappedBy = "patient", cascade =  CascadeType.ALL, orphanRemoval = true)
    List<MedicalReport> medicalReports = new ArrayList<>();

    @CreationTimestamp
    private LocalDateTime createdAt;

}
