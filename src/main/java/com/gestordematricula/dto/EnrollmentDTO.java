package com.gestordematricula.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class EnrollmentDTO {
    private UUID id;
    private UUID studentId;
    private UUID courseId;
}
