package ru.vsu.cs.buchnev.hospital.app.service;

import ru.vsu.cs.buchnev.hospital.item.model.DepartmentItem;

import java.util.List;

public interface DepartmentService {
    List<DepartmentItem> getAllDepartments();
    DepartmentItem getDepartment(Integer departmentId);
    DepartmentItem createDepartment(DepartmentItem departmentItem);
    DepartmentItem saveDepartment(DepartmentItem currentDepartment);
    void deleteDepartment(Integer departmentId);
}
