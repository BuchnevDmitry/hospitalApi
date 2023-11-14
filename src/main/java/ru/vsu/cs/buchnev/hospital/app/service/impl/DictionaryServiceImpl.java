package ru.vsu.cs.buchnev.hospital.app.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vsu.cs.buchnev.hospital.app.service.DictionaryService;
import ru.vsu.cs.buchnev.hospital.item.model.DoctorItem;
import ru.vsu.cs.buchnev.hospital.item.DoctorRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DictionaryServiceImpl implements DictionaryService {

    private final DoctorRepository doctorRepository;

    @Override
    public List<DoctorItem> getAllCountry() {
        return doctorRepository.findAll();
    }
}

