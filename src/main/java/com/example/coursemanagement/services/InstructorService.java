package com.example.coursemanagement.services;

import com.example.coursemanagement.models.Instructor;
import com.example.coursemanagement.models.dto.request.InstructorCreateRequest;

import java.util.List;

public interface InstructorService {
    List<Instructor> findAllInstructors();
    Instructor findInstructorById(Long id);
    Instructor createInstructor(InstructorCreateRequest req);
}
