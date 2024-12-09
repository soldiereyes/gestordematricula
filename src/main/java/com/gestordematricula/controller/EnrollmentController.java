package com.gestordematricula.controller;

import com.gestordematricula.dto.EnrollmentDTO;
import com.gestordematricula.service.EnrollmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {
    private final EnrollmentService service;

    public EnrollmentController(EnrollmentService service) {
        this.service = service;
    }

    @GetMapping
    public List<EnrollmentDTO> findAll() {
        return service.findAll();
    }

    @PostMapping
    public EnrollmentDTO save(@RequestBody EnrollmentDTO enrollmentDTO) {
        return service.save(enrollmentDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}