package ru.vsu.cs.buchnev.hospital.app.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.vsu.cs.buchnev.hospital.app.exeption.NotFoundException;
import ru.vsu.cs.buchnev.hospital.app.service.DoctorService;
import ru.vsu.cs.buchnev.hospital.specification.DoctorSpecifications;
import ru.vsu.cs.buchnev.hospital.item.DoctorRepository;
import ru.vsu.cs.buchnev.hospital.item.model.DoctorItem;
import ru.vsu.cs.buchnev.hospital.helper.Result;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;
    @Override
    public List<DoctorItem> getAllDoctors(PageRequest pageRequest) {
        Page<DoctorItem> page = doctorRepository.findAll(pageRequest);
        return page.getContent();
    }

    @Override
    public List<DoctorItem> getAllDoctors(String fio, String specialization, PageRequest pageRequest) {
        Page<DoctorItem> page = doctorRepository.findAll(Specification.where(DoctorSpecifications.hasFio(fio)).or(DoctorSpecifications.hasSpecialization(specialization)), pageRequest);
        return page.getContent();
    }

    @Override
    public Result getDoctorResult(Integer doctorId, String startDate, String endDate) {
        return doctorRepository.findServicesAndStatsByDoctorAndDateRange(doctorId);
        //        return doctorRepository.findServicesAndStatsByDoctorAndDateRange(doctorId, LocalDate.of(Integer.parseInt(start[2]), Integer.parseInt(start[1]), Integer.parseInt(start[0])), LocalDate.of(Integer.parseInt(end[2]), Integer.parseInt(end[1]), Integer.parseInt(end[0])));
    }

    @Override
    public DoctorItem getDoctor(Integer doctorId) {
        return doctorRepository.findById(doctorId).orElseThrow(() -> new NotFoundException("Doctor with this id not found"));
    }

    @Override
    public DoctorItem createDoctor(DoctorItem doctorItem) {
        return saveDoctor(doctorItem);
    }

    @Override
    public DoctorItem saveDoctor(DoctorItem currentDoctor) {
        return doctorRepository.saveAndFlush(currentDoctor);
    }

    @Override
    public void deleteDoctor(Integer doctorId) {
        doctorRepository.deleteById(doctorId);
    }
}
