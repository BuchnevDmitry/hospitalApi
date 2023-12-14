package ru.vsu.cs.buchnev.hospital.item;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vsu.cs.buchnev.hospital.item.model.PatientItem;
import ru.vsu.cs.buchnev.hospital.item.model.VisitItem;

import java.util.List;

public interface VisitRepository extends JpaRepository<VisitItem, Integer> {
    List<VisitItem> findByPatient(PatientItem patientItem);
}
