package ru.vsu.cs.buchnev.hospital.item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.vsu.cs.buchnev.hospital.item.model.DoctorItem;
import ru.vsu.cs.buchnev.hospital.helper.Result;

@Repository
public interface DoctorRepository extends JpaRepository<DoctorItem, Integer> {
    @Query(value =
            "SELECT COUNT(s.id) AS countService, SUM(s.price) AS sumServicePrice " +
                    "FROM doctor d " +
                    "JOIN visit v ON d.id = v.doctor_id " +
                    "JOIN service_visit sv ON v.id = sv.visit_id " +
                    "JOIN service s ON sv.service_id = s.id " +
                    "WHERE d.id = :doctorId",
            nativeQuery = true)
    Result findServicesAndStatsByDoctorAndDateRange(
            @Param("doctorId") Integer doctorId
    );
}
