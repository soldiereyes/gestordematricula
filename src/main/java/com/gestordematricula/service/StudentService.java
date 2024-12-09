package com.gestordematricula.service;

import com.gestordematricula.dto.StudentDTO;
import com.gestordematricula.model.Student;
import com.gestordematricula.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public List<StudentDTO> findAll() {
        return repository.findAll().stream()
                .map(student -> {
                    StudentDTO dto = new StudentDTO();
                    dto.setId(student.getId());
                    dto.setName(student.getName());
                    dto.setEmail(student.getEmail());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    public StudentDTO save(StudentDTO studentDTO) {
        Student student = new Student();
        student.setName(studentDTO.getName());
        student.setEmail(studentDTO.getEmail());
        Student saved = repository.save(student);
        studentDTO.setId(saved.getId());
        return studentDTO;
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }
}
