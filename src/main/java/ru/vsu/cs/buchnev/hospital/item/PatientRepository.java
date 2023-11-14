package ru.vsu.cs.buchnev.hospital.item;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vsu.cs.buchnev.hospital.item.model.PatientItem;

public interface PatientRepository extends JpaRepository<PatientItem, Integer> {

}
