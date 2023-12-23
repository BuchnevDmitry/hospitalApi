package ru.vsu.cs.buchnev.hospital.app.service;

import org.springframework.data.domain.PageRequest;
import ru.vsu.cs.buchnev.hospital.item.model.PatientItem;

import java.util.List;

public interface PatientService {
    List<PatientItem> getAllPatient(PageRequest pageRequest);
    PatientItem getPatient(Integer patientId);
    PatientItem createPatient(PatientItem patientItem);
    PatientItem savePatient(PatientItem currentPatient);
    void deletePatient(Integer patientId);
}
