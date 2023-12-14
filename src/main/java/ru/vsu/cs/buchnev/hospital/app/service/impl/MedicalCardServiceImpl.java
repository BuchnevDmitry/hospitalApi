package ru.vsu.cs.buchnev.hospital.app.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vsu.cs.buchnev.hospital.app.exeption.NotFoundException;
import ru.vsu.cs.buchnev.hospital.app.service.MedicalCardService;
import ru.vsu.cs.buchnev.hospital.item.MedicalCardRepository;
import ru.vsu.cs.buchnev.hospital.item.model.DoctorItem;
import ru.vsu.cs.buchnev.hospital.item.model.MedicalCardItem;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicalCardServiceImpl implements MedicalCardService {

    private final MedicalCardRepository medicalCardRepository;

    @Override
    public List<MedicalCardItem> getAllMedicalCard() {
        return medicalCardRepository.findAll();
    }

    @Override
    public MedicalCardItem getMedicalCard(Integer medicalCardId) {
        return medicalCardRepository.findById(medicalCardId).orElseThrow(() -> new NotFoundException("Medical card with this id not found"));
    }

    @Override
    public MedicalCardItem createMedicalCard(MedicalCardItem medicalCardItem) {
        return saveMedicalCard(medicalCardItem);
    }

    @Override
    public MedicalCardItem saveMedicalCard(MedicalCardItem currentMedicalCard) {
        return medicalCardRepository.saveAndFlush(currentMedicalCard);
    }

    @Override
    public void deleteMedicalCard(Integer medicalCardId) {
        medicalCardRepository.deleteById(medicalCardId);
    }
}
