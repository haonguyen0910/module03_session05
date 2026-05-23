package com.example.coursemanagement.services;

import com.example.coursemanagement.models.dto.request.StudentCreateRequest;

public interface StudentService {
    void createStudent(StudentCreateRequest req);
}
