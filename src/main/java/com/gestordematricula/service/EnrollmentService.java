package com.gestordematricula.service;

import com.gestordematricula.dto.EnrollmentDTO;
import com.gestordematricula.dto.StudentWithCoursesDTO;
import com.gestordematricula.model.Course;
import com.gestordematricula.model.Enrollment;
import com.gestordematricula.model.Student;
import com.gestordematricula.repository.CourseRepository;
import com.gestordematricula.repository.EnrollmentRepository;
import com.gestordematricula.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EnrollmentService {
    private final EnrollmentRepository repository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public EnrollmentService(EnrollmentRepository repository, StudentRepository studentRepository, CourseRepository courseRepository) {
        this.repository = repository;
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    public List<EnrollmentDTO> findAll() {
        return repository.findAll().stream()
                .map(enrollment -> {
                    EnrollmentDTO dto = new EnrollmentDTO();
                    dto.setId(enrollment.getId());
                    dto.setStudentId(enrollment.getStudent().getId());
                    dto.setCourseId(enrollment.getCourse().getId());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    public EnrollmentDTO save(EnrollmentDTO enrollmentDTO) {
        Student student = studentRepository.findById(enrollmentDTO.getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found"));
        Course course = courseRepository.findById(enrollmentDTO.getCourseId())
                .orElseThrow(() -> new RuntimeException("Course not found"));

        Enrollment enrollment = new Enrollment();
        enrollment.setStudent(student);
        enrollment.setCourse(course);
        Enrollment saved = repository.save(enrollment);
        enrollmentDTO.setId(saved.getId());
        return enrollmentDTO;
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }

    public List<StudentWithCoursesDTO> getStudentsWithCourses() {
        List<Student> students = studentRepository.findAll();

        return students.stream()
                .map(student -> {
                    List<String> courses = repository.findByStudent(student).stream()
                            .map(enrollment -> enrollment.getCourse().getName())
                            .collect(Collectors.toList());

                    return new StudentWithCoursesDTO(student.getName(), courses);
                })
                .collect(Collectors.toList());
    }

}