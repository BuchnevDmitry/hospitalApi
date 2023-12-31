package ru.vsu.cs.buchnev.hospital.app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.vsu.cs.buchnev.hospital.api.DepartmentApi;
import ru.vsu.cs.buchnev.hospital.api.model.request.DepartmentRequest;
import ru.vsu.cs.buchnev.hospital.api.model.response.*;
import ru.vsu.cs.buchnev.hospital.app.mapper.DepartmentMapper;
import ru.vsu.cs.buchnev.hospital.app.service.DepartmentService;
import ru.vsu.cs.buchnev.hospital.helper.Result;
import ru.vsu.cs.buchnev.hospital.item.model.DepartmentItem;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DepartmentController implements DepartmentApi {
    private final DepartmentService departmentService;
    private final DepartmentMapper departmentMapper;
    @Override
    public ResponseEntity<List<DepartmentResponse>> getAllDepartments(int page, int size) {
        List<DepartmentItem> allDepartment = departmentService.getAllDepartments(PageRequest.of(page,size));
        return ResponseEntity.ok(departmentMapper.mapToDto(allDepartment));
    }

    @Override
    public ResponseEntity<DepartmentResultResponse> getDepartmentResult(Integer departmentId, String start, String end) {
        Result result = departmentService.getDepartmentResult(departmentId, start, end);
        DepartmentResponse department = departmentMapper.mapToDto(departmentService.getDepartment(departmentId));
        return ResponseEntity.ok(new DepartmentResultResponse(department, result.getCountService(), result.getSumServicePrice()));
    }

    @Override
    public ResponseEntity<DepartmentResponse> getDepartment(Integer departmentId) {
        DepartmentItem departmentItem = departmentService.getDepartment(departmentId);
        return ResponseEntity.ok(departmentMapper.mapToDto(departmentItem));
    }

    @Override
    public ResponseEntity<DepartmentResponse> addDepartment(DepartmentRequest department) {
        DepartmentItem departmentItem = departmentMapper.mapRequestToItem(department);
        //departmentItem.setId(UUID.randomUUID());
        DepartmentItem createdDepartment = departmentService.createDepartment(departmentItem);
        return ResponseEntity.status(HttpStatus.CREATED).body(departmentMapper.mapToDto(createdDepartment));
    }


    @Override
    public ResponseEntity<DepartmentResponse> updateDepartment(Integer departmentId, DepartmentRequest department) {
        DepartmentItem departmentItem = departmentMapper.mapRequestToItem(department);
        DepartmentItem currentItem = departmentService.getDepartment(departmentId);
        currentItem.setName(departmentItem.getName());
        currentItem.setAddress(departmentItem.getAddress());
        DepartmentItem updatedDepartment = departmentService.saveDepartment(currentItem);
        return ResponseEntity.ok(departmentMapper.mapToDto(updatedDepartment));
    }

    @Override
    public ResponseEntity<Void> deleteDepartment(Integer departmentId) {
        departmentService.deleteDepartment(departmentId);
        return ResponseEntity.ok().build();
    }




}
