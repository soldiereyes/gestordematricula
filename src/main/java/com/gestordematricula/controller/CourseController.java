package com.gestordematricula.controller;

import com.gestordematricula.dto.CourseDTO;
import com.gestordematricula.service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    private final CourseService service;

    public CourseController(CourseService service) {
        this.service = service;
    }

    @GetMapping
    public List<CourseDTO> findAll() {
        return service.findAll();
    }

    @PostMapping
    public CourseDTO save(@RequestBody CourseDTO courseDTO) {
        return service.save(courseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/courses")
    public List<CourseDTO> getAllCourses() {
        return service.findAll();
    }

}
