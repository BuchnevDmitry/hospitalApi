package ru.vsu.cs.buchnev.hospital.app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.vsu.cs.buchnev.hospital.api.DepartmentApi;
import ru.vsu.cs.buchnev.hospital.api.model.DepartmentDto;
import ru.vsu.cs.buchnev.hospital.app.service.DepartmentService;
import ru.vsu.cs.buchnev.hospital.app.mapper.DepartmentMapper;
import ru.vsu.cs.buchnev.hospital.item.model.DepartmentItem;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class DepartmentController implements DepartmentApi {
    private final DepartmentService departmentService;
    @Override
    public ResponseEntity<List<DepartmentDto>> getAllDepartmnets() {
        List<DepartmentItem> allDepartment = departmentService.getAllDepartments();
        return ResponseEntity.ok(DepartmentMapper.INSTANCE.mapToDto(allDepartment));
    }

    @Override
    public ResponseEntity<DepartmentDto> getDepartment(Integer departmentId) {
        DepartmentItem departmentItem = departmentService.getDepartment(departmentId);
        return ResponseEntity.ok(DepartmentMapper.INSTANCE.mapToDto(departmentItem));
    }

    @Override
    public ResponseEntity<DepartmentDto> addDepartment(DepartmentDto department) {
        DepartmentItem departmentItem = DepartmentMapper.INSTANCE.mapToItem(department);
        //departmentItem.setId(UUID.randomUUID());
        DepartmentItem createdDepartment = departmentService.createDepartment(departmentItem);
        return ResponseEntity.status(HttpStatus.CREATED).body(DepartmentMapper.INSTANCE.mapToDto(createdDepartment));
    }


    @Override
    public ResponseEntity<DepartmentDto> updateDepartment(Integer departmentId, DepartmentDto department) {
        DepartmentItem currentItem = departmentService.getDepartment(departmentId);
        currentItem.setName(department.getName());
        currentItem.setAddress(department.getAddress());
        DepartmentItem updatedDepartment = departmentService.saveDepartment(currentItem);
        return ResponseEntity.ok(DepartmentMapper.INSTANCE.mapToDto(updatedDepartment));
    }

    @Override
    public ResponseEntity<Void> deleteDepartment(Integer departmentId) {
        departmentService.deleteDepartment(departmentId);
        return ResponseEntity.ok().build();
    }
}
