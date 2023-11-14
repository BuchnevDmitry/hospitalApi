package ru.vsu.cs.buchnev.hospital.item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vsu.cs.buchnev.hospital.item.model.DoctorItem;

@Repository
public interface DoctorRepository extends JpaRepository<DoctorItem, Integer> {

}
