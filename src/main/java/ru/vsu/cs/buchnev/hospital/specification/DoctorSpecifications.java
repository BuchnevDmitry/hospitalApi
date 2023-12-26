package ru.vsu.cs.buchnev.hospital.specification;

import org.springframework.data.jpa.domain.Specification;
import ru.vsu.cs.buchnev.hospital.item.model.DoctorItem;

public class DoctorSpecifications {

    public static Specification<DoctorItem> hasFio(String fio) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("fio"), "%" + fio + "%");
    }

    public static Specification<DoctorItem> hasSpecialization(String specalization) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("specalization"), "%" + specalization + "%");
    }
}
