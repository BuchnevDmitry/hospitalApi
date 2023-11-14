package ru.vsu.cs.buchnev.hospital.app.service;

import ru.vsu.cs.buchnev.hospital.api.model.DepartmentDto;
import ru.vsu.cs.buchnev.hospital.item.model.DepartmentItem;

import java.util.List;
import java.util.UUID;

public interface DepartmentService {
    List<DepartmentItem> getAllDepartments();
    DepartmentItem getDepartment(Integer departmentId);
    DepartmentItem createDepartment(DepartmentItem departmentItem);
    DepartmentItem saveDepartment(DepartmentItem currentDepartment);
    void deleteDepartment(Integer departmentId);

}
