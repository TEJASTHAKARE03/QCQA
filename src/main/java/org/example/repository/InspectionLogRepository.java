package org.example.repository;

import org.example.model.InspectionLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InspectionLogRepository extends JpaRepository<InspectionLog, Long> {
}
