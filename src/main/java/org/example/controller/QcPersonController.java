package org.example.controller;

import jakarta.validation.Valid;
import org.example.model.QcPerson;
import org.example.service.QcPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/qc-persons")
public class QcPersonController {

    @Autowired
    private QcPersonService qcPersonService;

    @PostMapping
    public ResponseEntity<QcPerson> createQcPerson(@Valid @RequestBody QcPerson qcPerson) {
        QcPerson savedQcPerson = qcPersonService.saveQcPerson(qcPerson);
        return new ResponseEntity<>(savedQcPerson, HttpStatus.CREATED);
    }

    @GetMapping
    public List<QcPerson> getAllQcPersons() {
        return qcPersonService.getAllQcPersons();
    }

    @GetMapping("/{id}")
    public ResponseEntity<QcPerson> getQcPersonById(@PathVariable Integer id) {
        return qcPersonService.getQcPersonById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
