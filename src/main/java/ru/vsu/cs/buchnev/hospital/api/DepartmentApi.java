package ru.vsu.cs.buchnev.hospital.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vsu.cs.buchnev.hospital.api.model.DepartmentDto;

import java.util.List;
import java.util.UUID;

public interface DepartmentApi {

    @GetMapping("/departments")
    ResponseEntity<List<DepartmentDto>> getAllDepartmnets();

    @GetMapping("/department/{departmentId}")
    ResponseEntity<DepartmentDto> getDepartment(
            @PathVariable("departmentId")
            Integer departmentId
    );

    @PostMapping("/departments")
    ResponseEntity<DepartmentDto> addDepartment(
            @RequestBody
            DepartmentDto department
    );

    @PostMapping("/departments/{departmentId}")
    ResponseEntity<DepartmentDto> updateDepartment(
            @PathVariable("departmentId")
            Integer departmentId,

            @RequestBody
            DepartmentDto department
    );

    @DeleteMapping("/departments/{departmentId}")
    ResponseEntity<Void> deleteDepartment(
            @PathVariable("departmentId")
            Integer departmentId
    );

}
