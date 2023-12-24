package ru.vsu.cs.buchnev.hospital.item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.vsu.cs.buchnev.hospital.helper.Result;
import ru.vsu.cs.buchnev.hospital.item.model.DepartmentItem;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentItem, Integer> {
    @Query(value =
            "SELECT COUNT(sv.service_id) AS countService, SUM(s.price) AS sumServicePrice " +
                    "FROM service_visit sv " +
                    "JOIN visit v ON sv.visit_id = v.id " +
                    "JOIN doctor d ON v.doctor_id = d.id " +
                    "JOIN service s ON sv.service_id = s.id " +
                    "WHERE d.department_id = :departmentId",
            nativeQuery = true)
    Result findServicesAndStatsByDepartmentAndDateRange(
            @Param("departmentId") Integer departmentId
    );
}
