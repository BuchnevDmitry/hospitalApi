package ru.vsu.cs.buchnev.hospital.item;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vsu.cs.buchnev.hospital.item.model.DoctorItem;
import ru.vsu.cs.buchnev.hospital.item.model.MedicalCardItem;

public interface MedicalCardRepository extends JpaRepository<MedicalCardItem, Integer> {
}
