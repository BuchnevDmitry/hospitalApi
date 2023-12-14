package ru.vsu.cs.buchnev.hospital.app.service;

import ru.vsu.cs.buchnev.hospital.item.model.MedicalCardItem;
import ru.vsu.cs.buchnev.hospital.item.model.PatientItem;

import java.util.List;

public interface PatientService {
    List<PatientItem> getAllPatient();
    PatientItem getPatient(Integer patientId);
    PatientItem createPatient(PatientItem patientItem);
    PatientItem savePatient(PatientItem currentPatient);
    void deletePatient(Integer patientId);
}
