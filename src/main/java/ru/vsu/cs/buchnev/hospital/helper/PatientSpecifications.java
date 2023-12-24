package ru.vsu.cs.buchnev.hospital.helper;

import org.springframework.data.jpa.domain.Specification;
import ru.vsu.cs.buchnev.hospital.item.model.PatientItem;

public class PatientSpecifications {
    public static Specification<PatientItem> hasFio(String fio) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("fio"), "%" + fio + "%");
    }

    public static Specification<PatientItem> hasPhoneNumber(String phoneNumber) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("phoneNumber"), phoneNumber);
    }

    public static Specification<PatientItem> hasAddress(String address) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("address"), "%" + address + "%");
    }
}
