package com.gestordematricula.repository;

import com.gestordematricula.model.Enrollment;
import com.gestordematricula.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface EnrollmentRepository  extends JpaRepository<Enrollment, UUID> {
    List<Enrollment> findByStudent(Student student);
}
