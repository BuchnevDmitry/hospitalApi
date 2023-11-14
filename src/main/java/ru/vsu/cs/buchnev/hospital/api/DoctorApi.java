package ru.vsu.cs.buchnev.hospital.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vsu.cs.buchnev.hospital.api.model.DepartmentDto;
import ru.vsu.cs.buchnev.hospital.api.model.DoctorDto;

import java.util.List;
import java.util.UUID;

public interface DoctorApi {

    @GetMapping("/doctors")
    ResponseEntity<List<DoctorDto>> getAllDoctors();

    @GetMapping("/doctors/{doctorsId}")
    ResponseEntity<DoctorDto> getDoctor(
            @PathVariable("doctorId")
            UUID departmentId
    );

    @PostMapping("/doctors")
    ResponseEntity<DoctorDto> addDoctors(
            @RequestBody
            DoctorDto doctor
    );

    @PostMapping("/doctor/{doctorId}")
    ResponseEntity<DoctorDto> updateDoctor(
            @PathVariable("doctorId")
            UUID doctorId,

            @RequestBody
            DoctorDto doctor
    );

    @DeleteMapping("/doctor/{doctorId}")
    ResponseEntity<Void> deleteDoctor(
            @PathVariable("doctorId")
            UUID doctorId
    );

}
