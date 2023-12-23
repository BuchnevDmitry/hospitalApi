package ru.vsu.cs.buchnev.hospital.app.service;

import org.springframework.data.domain.PageRequest;
import ru.vsu.cs.buchnev.hospital.item.model.DepartmentItem;

import java.util.List;

public interface DepartmentService {
    List<DepartmentItem> getAllDepartments(PageRequest pageRequest);
    DepartmentItem getDepartment(Integer departmentId);
    DepartmentItem createDepartment(DepartmentItem departmentItem);
    DepartmentItem saveDepartment(DepartmentItem currentDepartment);
    void deleteDepartment(Integer departmentId);
}
