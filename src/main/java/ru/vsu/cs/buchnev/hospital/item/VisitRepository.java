package ru.vsu.cs.buchnev.hospital.item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import ru.vsu.cs.buchnev.hospital.item.model.PatientItem;
import ru.vsu.cs.buchnev.hospital.item.model.VisitItem;

import java.util.List;

public interface VisitRepository extends JpaRepository<VisitItem, Integer>, JpaSpecificationExecutor<VisitItem> {
    List<VisitItem> findByPatient(PatientItem patientItem);
}
