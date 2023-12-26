package ru.vsu.cs.buchnev.hospital.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vsu.cs.buchnev.hospital.api.model.request.DoctorRequest;
import ru.vsu.cs.buchnev.hospital.api.model.response.DoctorResponse;
import ru.vsu.cs.buchnev.hospital.api.model.response.DoctorResultResponse;
import ru.vsu.cs.buchnev.hospital.api.model.response.PatientResponse;

import java.time.LocalDate;
import java.util.List;

public interface DoctorApi {

    @GetMapping("/doctors")
    ResponseEntity<List<DoctorResponse>> getAllDoctors(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int size
    );

    @GetMapping("/doctor/{doctorId}")
    ResponseEntity<DoctorResponse> getDoctor(
            @PathVariable("doctorId")
            Integer doctorId
    );

    @GetMapping("/doctors/find")
    ResponseEntity<List<DoctorResponse>> getDoctorsWithFilter(
            @RequestParam(required = false) String fio,
            @RequestParam(required = false) String specialization,
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int size
    );

    @GetMapping("/doctor/result/{doctorId}")
    ResponseEntity<DoctorResultResponse> getDoctorResult(
            @PathVariable("doctorId")
            Integer doctorId,
            @RequestParam(required = false) String start,
            @RequestParam(required = false) String end
    );

    @PostMapping("/doctor")
    ResponseEntity<DoctorResponse> addDoctors(
            @RequestBody
            DoctorRequest doctor
    );

    @PutMapping("/doctor/{doctorId}")
    ResponseEntity<DoctorResponse> updateDoctor(
            @PathVariable("doctorId")
            Integer doctorId,

            @RequestBody
            DoctorRequest doctor
    );

    @DeleteMapping("/doctor/{doctorId}")
    ResponseEntity<Void> deleteDoctor(
            @PathVariable("doctorId")
            Integer doctorId
    );

}
