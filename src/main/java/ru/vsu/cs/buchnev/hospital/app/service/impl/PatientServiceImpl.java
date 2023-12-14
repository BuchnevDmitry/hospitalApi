package ru.vsu.cs.buchnev.hospital.app.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vsu.cs.buchnev.hospital.app.exeption.NotFoundException;
import ru.vsu.cs.buchnev.hospital.app.service.PatientService;
import ru.vsu.cs.buchnev.hospital.item.PatientRepository;
import ru.vsu.cs.buchnev.hospital.item.model.PatientItem;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;
    @Override
    public List<PatientItem> getAllPatient() {
        return patientRepository.findAll();
    }

    @Override
    public PatientItem getPatient(Integer patientId) {
        return patientRepository.findById(patientId).orElseThrow(() -> new NotFoundException("Patient with this id not found"));
    }

    @Override
    public PatientItem createPatient(PatientItem patientItem) {
        return savePatient(patientItem);
    }

    @Override
    public PatientItem savePatient(PatientItem currentPatient) {
        return patientRepository.saveAndFlush(currentPatient);
    }

    @Override
    public void deletePatient(Integer patientId) {
        patientRepository.deleteById(patientId);
    }
}
