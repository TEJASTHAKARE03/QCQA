package org.example.repository;

import org.example.model.Checklist;
import org.example.model.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChecklistRepository extends JpaRepository<Checklist, Long> {
    List<Checklist> findByVehicleType(VehicleType vehicleType);
}
