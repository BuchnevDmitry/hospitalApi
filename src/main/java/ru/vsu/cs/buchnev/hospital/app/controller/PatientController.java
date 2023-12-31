package ru.vsu.cs.buchnev.hospital.app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.vsu.cs.buchnev.hospital.api.PatientApi;
import ru.vsu.cs.buchnev.hospital.api.model.request.PatientRequest;
import ru.vsu.cs.buchnev.hospital.api.model.response.PatientResponse;
import ru.vsu.cs.buchnev.hospital.app.mapper.PatientMapper;
import ru.vsu.cs.buchnev.hospital.app.service.PatientService;
import ru.vsu.cs.buchnev.hospital.item.model.PatientItem;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class PatientController implements PatientApi {

    private final PatientService patientService;
    private final PatientMapper patientMapper;
    @Override
    public ResponseEntity<List<PatientResponse>> getAllPatients(int page, int size, String sortParam) {
        List<PatientItem> allPatients = patientService.getAllPatient(PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, sortParam)));
        return ResponseEntity.ok(patientMapper.mapToDto(allPatients));
    }

    @Override
    public ResponseEntity<List<PatientResponse>> getPatientsWithFilter(String fio, String phoneNumber, String address, int page, int size) {
        List<PatientItem> allPatients = patientService.getAllPatient(fio, phoneNumber, address, PageRequest.of(page, size));
        return ResponseEntity.ok(patientMapper.mapToDto(allPatients));
    }

    @Override
    public ResponseEntity<PatientResponse> getPatient(Integer patientId) {
        PatientItem patientItem = patientService.getPatient(patientId);
        return ResponseEntity.ok(patientMapper.mapToDto(patientItem));
    }

    @Override
    public ResponseEntity<PatientResponse> addPatients(PatientRequest patient) {
        PatientItem patientItem = patientMapper.mapRequestToItem(patient);
        PatientItem createdPatient = patientService.createPatient(patientItem);
        return ResponseEntity.status(HttpStatus.CREATED).body(patientMapper.mapToDto(createdPatient));
    }

    @Override
    public ResponseEntity<PatientResponse> updatePatient(Integer patientId, PatientRequest patient) {
        PatientItem patientItem = patientMapper.mapRequestToItem(patient);
        PatientItem currentItem = patientService.getPatient(patientId);
        currentItem.setFio(patientItem.getFio());
        currentItem.setAddress(patientItem.getAddress());
        currentItem.setPhoneNumber(patientItem.getPhoneNumber());
        PatientItem updatedPatient = patientService.savePatient(currentItem);
        return ResponseEntity.ok(patientMapper.mapToDto(updatedPatient));
    }

    @Override
    public ResponseEntity<Void> deletePatient(Integer patientId) {
        patientService.deletePatient(patientId);
        return ResponseEntity.ok().build();
    }
}
