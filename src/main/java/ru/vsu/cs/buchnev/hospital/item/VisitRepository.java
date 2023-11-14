package ru.vsu.cs.buchnev.hospital.item;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vsu.cs.buchnev.hospital.item.model.VisitItem;

public interface VisitRepository extends JpaRepository<VisitItem, Integer> {
}
