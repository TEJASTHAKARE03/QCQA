package org.example.controller;

import jakarta.validation.Valid;
import org.example.dto.CreateQcPersonRequest;
import org.example.dto.QcPersonResponse;
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
    public ResponseEntity<QcPersonResponse> createQcPerson(@Valid @RequestBody CreateQcPersonRequest request) {
        QcPersonResponse savedQcPerson = qcPersonService.saveQcPerson(request);
        return new ResponseEntity<>(savedQcPerson, HttpStatus.CREATED);
    }

    @GetMapping
    public List<QcPersonResponse> getAllQcPersons() {
        return qcPersonService.getAllQcPersons();
    }

    @GetMapping("/{id}")
    public ResponseEntity<QcPersonResponse> getQcPersonById(@PathVariable Integer id) {
        return qcPersonService.getQcPersonById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
