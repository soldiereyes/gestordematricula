package com.gestordematricula.controller;

import com.gestordematricula.dto.StudentDTO;
import com.gestordematricula.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping
    public List<StudentDTO> findAll() {
        return service.findAll();
    }

    @PostMapping
    public StudentDTO save(@RequestBody StudentDTO studentDTO) {
        return service.save(studentDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/students")
    public List<StudentDTO> getAllStudents() {
        return service.findAll();
    }

}