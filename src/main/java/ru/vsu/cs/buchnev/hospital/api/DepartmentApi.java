package ru.vsu.cs.buchnev.hospital.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vsu.cs.buchnev.hospital.api.model.request.DepartmentRequest;
import ru.vsu.cs.buchnev.hospital.api.model.response.DepartmentResponse;

import java.util.List;

public interface DepartmentApi {

    @GetMapping("/departments")
    ResponseEntity<List<DepartmentResponse>> getAllDepartmnets();

    @GetMapping("/department/{departmentId}")
    ResponseEntity<DepartmentResponse> getDepartment(
            @PathVariable("departmentId")
            Integer departmentId
    );

    @PostMapping("/departments")
    ResponseEntity<DepartmentResponse> addDepartment(
            @RequestBody
            DepartmentRequest department
    );

    @PutMapping("/department/{departmentId}")
    ResponseEntity<DepartmentResponse> updateDepartment(
            @PathVariable("departmentId")
            Integer departmentId,

            @RequestBody
            DepartmentRequest department
    );

    @DeleteMapping("/department/{departmentId}")
    ResponseEntity<Void> deleteDepartment(
            @PathVariable("departmentId")
            Integer departmentId
    );


}
