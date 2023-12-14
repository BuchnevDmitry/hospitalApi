package ru.vsu.cs.buchnev.hospital.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vsu.cs.buchnev.hospital.api.model.request.DoctorRequest;
import ru.vsu.cs.buchnev.hospital.api.model.response.DoctorResponse;

import java.util.List;

public interface DoctorApi {

    @GetMapping("/doctors")
    ResponseEntity<List<DoctorResponse>> getAllDoctors();

    @GetMapping("/doctor/{doctorId}")
    ResponseEntity<DoctorResponse> getDoctor(
            @PathVariable("doctorId")
            Integer doctorId
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
