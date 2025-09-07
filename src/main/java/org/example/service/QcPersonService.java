package org.example.service;

import org.example.dto.CreateQcPersonRequest;
import org.example.dto.QcPersonResponse;
import org.example.model.QcPerson;
import org.example.repository.QcPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QcPersonService {

    @Autowired
    private QcPersonRepository qcPersonRepository;

    public QcPersonResponse saveQcPerson(CreateQcPersonRequest request) {
        QcPerson qcPerson = new QcPerson();
        qcPerson.setName(request.name());
        qcPerson.setQcScore(request.qcScore());
        qcPerson.setVehicleType(request.vehicleType());

        QcPerson savedPerson = qcPersonRepository.save(qcPerson);

        return toQcPersonResponse(savedPerson);
    }

    public List<QcPersonResponse> getAllQcPersons() {
        return qcPersonRepository.findAll()
                .stream()
                .map(this::toQcPersonResponse)
                .collect(Collectors.toList());
    }

    public Optional<QcPersonResponse> getQcPersonById(Integer id) {
        return qcPersonRepository.findById(id)
                .map(this::toQcPersonResponse);
    }

    private QcPersonResponse toQcPersonResponse(QcPerson person) {
        return new QcPersonResponse(
                person.getId(),
                person.getName(),
                person.getQcScore(),
                person.getVehicleType()
        );
    }
}
