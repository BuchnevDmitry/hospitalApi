package ru.vsu.cs.buchnev.hospital.app.service;

import ru.vsu.cs.buchnev.hospital.item.model.DoctorItem;
import ru.vsu.cs.buchnev.hospital.item.model.MedicalCardItem;

import java.util.List;

public interface MedicalCardService {
    List<MedicalCardItem> getAllMedicalCard();
    MedicalCardItem getMedicalCard(Integer medicalCardId);
    MedicalCardItem createMedicalCard(MedicalCardItem medicalCardItem);
    MedicalCardItem saveMedicalCard(MedicalCardItem currentMedicalCard);
    void deleteMedicalCard(Integer medicalCardId);
}
