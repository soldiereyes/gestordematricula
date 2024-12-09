package com.gestordematricula.repository;

import com.gestordematricula.model.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EnrollmentRepository  extends JpaRepository<Enrollment, UUID> {
}
