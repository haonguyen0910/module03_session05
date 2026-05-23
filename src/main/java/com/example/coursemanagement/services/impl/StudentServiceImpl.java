package com.example.coursemanagement.services.impl;

import com.example.coursemanagement.models.Student;
import com.example.coursemanagement.models.dto.request.StudentCreateRequest;
import com.example.coursemanagement.repositories.StudentRepository;
import com.example.coursemanagement.services.StudentService;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void createStudent(StudentCreateRequest req) {
        Student student = new Student();

        student.setName(req.getName());
        student.setEmail(req.getEmail());

        studentRepository.save(student);
    }
}
