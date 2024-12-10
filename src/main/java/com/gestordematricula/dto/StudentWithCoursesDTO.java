package com.gestordematricula.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class StudentWithCoursesDTO {
    private String studentName;
    private List<String> courses;
}
