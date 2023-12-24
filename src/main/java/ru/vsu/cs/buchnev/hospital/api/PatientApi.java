package ru.vsu.cs.buchnev.hospital.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vsu.cs.buchnev.hospital.api.model.request.PatientRequest;
import ru.vsu.cs.buchnev.hospital.api.model.response.PatientResponse;

import java.util.List;

public interface PatientApi {
    @GetMapping("/patients")
    ResponseEntity<List<PatientResponse>> getAllPatients(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int size,
            @RequestParam(required = false, defaultValue = "id") String sortParam
            );

    @GetMapping("/patients/find")
    ResponseEntity<List<PatientResponse>> getPatientsWithFilter(
            @RequestParam(required = false) String fio,
            @RequestParam(required = false) String phoneNumber,
            @RequestParam(required = false) String address,
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int size
            );

    @GetMapping("/patient/{patientId}")
    ResponseEntity<PatientResponse> getPatient(
            @PathVariable("patientId")
            Integer patientId
    );

    @PostMapping("/patient")
    ResponseEntity<PatientResponse> addPatients(
            @RequestBody
            PatientRequest patient
    );

    @PutMapping("/patient/{patientId}")
    ResponseEntity<PatientResponse> updatePatient(
            @PathVariable("patientId")
            Integer patientId,

            @RequestBody
            PatientRequest patient
    );

    @DeleteMapping("/patient/{patientId}")
    ResponseEntity<Void> deletePatient(
            @PathVariable("patientId")
            Integer patientId
    );
}
