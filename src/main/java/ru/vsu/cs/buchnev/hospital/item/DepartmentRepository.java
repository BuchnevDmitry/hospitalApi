package ru.vsu.cs.buchnev.hospital.item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vsu.cs.buchnev.hospital.item.model.DepartmentItem;
import ru.vsu.cs.buchnev.hospital.item.model.DoctorItem;

import java.util.UUID;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentItem, Integer> {
}
