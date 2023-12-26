package ru.vsu.cs.buchnev.hospital.specification;

import org.springframework.data.jpa.domain.Specification;
import ru.vsu.cs.buchnev.hospital.item.model.ServiceItem;

public class ServiceSpecifications {
    public static Specification<ServiceItem> hasName(String name) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("name"), "%" + name + "%");
    }
}
