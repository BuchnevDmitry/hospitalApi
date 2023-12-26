package ru.vsu.cs.buchnev.hospital.specification;

import org.springframework.data.jpa.domain.Specification;
import ru.vsu.cs.buchnev.hospital.item.model.ServiceItem;
import ru.vsu.cs.buchnev.hospital.item.model.VisitItem;

import java.time.LocalDate;

public class VisitSpecifications {
    public static Specification<VisitItem> visitedAfter(LocalDate date) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThan(root.get("dateVisit"), date);
    }
}
