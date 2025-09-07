package org.example.repository;

import org.example.model.QcPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QcPersonRepository extends JpaRepository<QcPerson, Integer> {
}
