package ru.vsu.cs.buchnev.hospital.app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.vsu.cs.buchnev.hospital.api.DoctorApi;
import ru.vsu.cs.buchnev.hospital.api.model.request.DoctorRequest;
import ru.vsu.cs.buchnev.hospital.api.model.response.DoctorResponse;
import ru.vsu.cs.buchnev.hospital.api.model.response.DoctorResultResponse;
import ru.vsu.cs.buchnev.hospital.api.model.response.PatientResponse;
import ru.vsu.cs.buchnev.hospital.app.exeption.BadRequestException;
import ru.vsu.cs.buchnev.hospital.app.mapper.DoctorMapper;
import ru.vsu.cs.buchnev.hospital.app.service.DoctorService;
import ru.vsu.cs.buchnev.hospital.item.model.DoctorItem;
import ru.vsu.cs.buchnev.hospital.helper.Result;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DoctorController implements DoctorApi {

    private final DoctorService doctorService;
//    private final DepartmentService departmentService;
    private final DoctorMapper doctorMapper;
    @Override
    public ResponseEntity<List<DoctorResponse>> getAllDoctors(int page, int size) {
        List<DoctorItem> allDoctors = doctorService.getAllDoctors(PageRequest.of(page, size));
        return ResponseEntity.ok(doctorMapper.mapToDto(allDoctors));
    }

    @Override
    public ResponseEntity<DoctorResponse> getDoctor(Integer doctorId) {
        DoctorItem doctorItem = doctorService.getDoctor(doctorId);
        return ResponseEntity.ok(doctorMapper.mapToDto(doctorItem));
    }

    @Override
    public ResponseEntity<List<DoctorResponse>> getDoctorsWithFilter(String fio, String specialization, int page, int size) {
        List<DoctorItem> allDoctors = doctorService.getAllDoctors(fio,specialization, PageRequest.of(page, size));
        return ResponseEntity.ok(doctorMapper.mapToDto(allDoctors));
    }


    @Override
    public ResponseEntity<DoctorResultResponse> getDoctorResult(Integer doctorId, String start, String end) {
        Result result = doctorService.getDoctorResult(doctorId, start, end);
        DoctorResponse doctor = doctorMapper.mapToDto(doctorService.getDoctor(doctorId));
        return ResponseEntity.ok(new DoctorResultResponse(doctor, result.getCountService(), result.getSumServicePrice()));
    }

    @Override
    public ResponseEntity<DoctorResponse> addDoctors(DoctorRequest doctor) {
        try {
            DoctorItem doctorItem = doctorMapper.mapRequestToItem(doctor);
            DoctorItem createdDoctor = doctorService.createDoctor(doctorItem);
            return ResponseEntity.status(HttpStatus.CREATED).body(doctorMapper.mapToDto(createdDoctor));
        }
        catch (Exception e) {
            throw new BadRequestException("Введены неправильные данные для запроса");
        }
    }

    @Override
    public ResponseEntity<DoctorResponse> updateDoctor(Integer doctorId, DoctorRequest doctor) {
        DoctorItem doctorItem = doctorMapper.mapRequestToItem(doctor);
        DoctorItem currentItem = doctorService.getDoctor(doctorId);
        currentItem.setFio(doctorItem.getFio());
        currentItem.setSpecalization(doctorItem.getSpecalization());
        currentItem.setDepartment(doctorItem.getDepartment());
        DoctorItem updatedDoctor = doctorService.saveDoctor(currentItem);
        return ResponseEntity.ok(doctorMapper.mapToDto(updatedDoctor));
    }

    @Override
    public ResponseEntity<Void> deleteDoctor(Integer doctorId) {
        doctorService.deleteDoctor(doctorId);
        return ResponseEntity.ok().build();
    }
}
