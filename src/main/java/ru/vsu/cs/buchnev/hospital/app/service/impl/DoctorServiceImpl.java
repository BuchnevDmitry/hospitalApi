package ru.vsu.cs.buchnev.hospital.app.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vsu.cs.buchnev.hospital.app.exeption.NotFoundException;
import ru.vsu.cs.buchnev.hospital.app.service.DoctorService;
import ru.vsu.cs.buchnev.hospital.item.DoctorRepository;
import ru.vsu.cs.buchnev.hospital.item.model.DoctorItem;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;
    @Override
    public List<DoctorItem> getAllDoctors() {
        return doctorRepository.findAll();
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
