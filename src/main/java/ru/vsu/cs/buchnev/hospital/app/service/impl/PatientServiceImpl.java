package ru.vsu.cs.buchnev.hospital.app.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.vsu.cs.buchnev.hospital.app.exeption.NotFoundException;
import ru.vsu.cs.buchnev.hospital.app.service.PatientService;
import ru.vsu.cs.buchnev.hospital.specification.PatientSpecifications;
import ru.vsu.cs.buchnev.hospital.item.PatientRepository;
import ru.vsu.cs.buchnev.hospital.item.model.PatientItem;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;
    @Override
    public List<PatientItem> getAllPatient(PageRequest pageRequest) {
        Page<PatientItem> page = patientRepository.findAll(pageRequest);
        return page.getContent();
    }
    public List<PatientItem> getAllPatient(String fio, String phoneNumber, String address, PageRequest pageRequest) {
        Page<PatientItem> page = patientRepository.findAll(Specification.where(PatientSpecifications.hasFio(fio)).or(PatientSpecifications.hasPhoneNumber(phoneNumber)).or(PatientSpecifications.hasAddress(address)), pageRequest);
        return page.getContent();
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
