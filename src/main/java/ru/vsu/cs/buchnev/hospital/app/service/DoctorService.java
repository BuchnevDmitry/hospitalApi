package ru.vsu.cs.buchnev.hospital.app.service;

import ru.vsu.cs.buchnev.hospital.item.model.DepartmentItem;
import ru.vsu.cs.buchnev.hospital.item.model.DoctorItem;

import java.util.List;

public interface DoctorService {
    List<DoctorItem> getAllDoctors();
    DoctorItem getDoctor(Integer doctorId);
    DoctorItem createDoctor(DoctorItem doctorItem);
    DoctorItem saveDoctor(DoctorItem currentDoctor);
    void deleteDoctor(Integer doctorId);
}
