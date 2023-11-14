package ru.vsu.cs.buchnev.hospital.item;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vsu.cs.buchnev.hospital.item.model.ServiceItem;

public interface ServiceRepository extends JpaRepository<ServiceItem, Integer> {
}
