package com.gestordematricula.service;

import com.gestordematricula.dto.CourseDTO;
import com.gestordematricula.model.Course;
import com.gestordematricula.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CourseService {
    private final CourseRepository repository;

    public CourseService(CourseRepository repository) {
        this.repository = repository;
    }

    public List<CourseDTO> findAll() {
        return repository.findAll().stream()
                .map(course -> {
                    CourseDTO dto = new CourseDTO();
                    dto.setId(course.getId());
                    dto.setName(course.getName());
                    dto.setDescription(course.getDescription());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    public CourseDTO save(CourseDTO courseDTO) {
        Course course = new Course();
        course.setName(courseDTO.getName());
        course.setDescription(courseDTO.getDescription());
        Course saved = repository.save(course);
        courseDTO.setId(saved.getId());
        return courseDTO;
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }
}