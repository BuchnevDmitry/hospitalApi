package ru.vsu.cs.buchnev.hospital.item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.vsu.cs.buchnev.hospital.helper.Result;
import ru.vsu.cs.buchnev.hospital.item.model.ServiceItem;

public interface ServiceRepository extends JpaRepository<ServiceItem, Integer>, JpaSpecificationExecutor<ServiceItem> {

    @Query(value =
            "SELECT COUNT(sv.service_id) AS countService, SUM(s.price) AS sumServicePrice " +
            "FROM doctor d " +
            "JOIN visit v ON d.id = v.doctor_id " +
            "JOIN service_visit sv ON v.id = sv.visit_id " +
            "JOIN service s ON sv.service_id = s.id ",
            nativeQuery = true)
    Result findServicesAndStatsByAllAndDateRange();
}
