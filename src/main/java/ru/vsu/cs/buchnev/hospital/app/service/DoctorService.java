package ru.vsu.cs.buchnev.hospital.app.service;

import org.springframework.data.domain.PageRequest;
import ru.vsu.cs.buchnev.hospital.item.model.DoctorItem;
import ru.vsu.cs.buchnev.hospital.helper.Result;

import java.util.List;

public interface DoctorService {
    List<DoctorItem> getAllDoctors(PageRequest pageRequest);

    Result getDoctorResult(Integer doctorId, String startDate, String endDate);
    DoctorItem getDoctor(Integer doctorId);
    DoctorItem createDoctor(DoctorItem doctorItem);
    DoctorItem saveDoctor(DoctorItem currentDoctor);
    void deleteDoctor(Integer doctorId);
}
