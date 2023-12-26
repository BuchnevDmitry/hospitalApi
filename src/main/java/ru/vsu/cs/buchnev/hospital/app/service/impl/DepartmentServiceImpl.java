package ru.vsu.cs.buchnev.hospital.app.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.vsu.cs.buchnev.hospital.app.exeption.DepartmentException;
import ru.vsu.cs.buchnev.hospital.app.exeption.NotFoundException;
import ru.vsu.cs.buchnev.hospital.app.service.DepartmentService;
import ru.vsu.cs.buchnev.hospital.helper.Result;
import ru.vsu.cs.buchnev.hospital.item.DepartmentRepository;
import ru.vsu.cs.buchnev.hospital.item.model.DepartmentItem;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;
    @Override
    public List<DepartmentItem> getAllDepartments(PageRequest pageRequest) {
        Page<DepartmentItem> page = departmentRepository.findAll(pageRequest);
        return page.getContent();
    }

    @Override
    public Result getDepartmentResult(Integer departmentId, String startDate, String endDate) {
        return departmentRepository.findServicesAndStatsByDepartmentAndDateRange(departmentId);
    }

    @Override
    public DepartmentItem getDepartment(Integer departmentId) {
        return departmentRepository.findById(departmentId).orElseThrow(() -> new NotFoundException("Department with this id not found"));
    }

    @Override
    public DepartmentItem createDepartment(DepartmentItem departmentItem) {
        return saveDepartment(departmentItem);
    }

    @Override
    public DepartmentItem saveDepartment(DepartmentItem currentDepartment) {
        return departmentRepository.saveAndFlush(currentDepartment);
    }

    @Override
    public void deleteDepartment(Integer departmentId) {
        departmentRepository.deleteById(departmentId);
    }
}
