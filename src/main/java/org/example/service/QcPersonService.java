package org.example.service;

import org.example.model.QcPerson;
import org.example.repository.QcPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QcPersonService {

    @Autowired
    private QcPersonRepository qcPersonRepository;

    public QcPerson saveQcPerson(QcPerson qcPerson) {
        return qcPersonRepository.save(qcPerson);
    }

    public List<QcPerson> getAllQcPersons() {
        return qcPersonRepository.findAll();
    }

    public Optional<QcPerson> getQcPersonById(Integer id) {
        return qcPersonRepository.findById(id);
    }
}
