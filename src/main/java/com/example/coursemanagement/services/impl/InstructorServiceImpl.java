package com.example.coursemanagement.services.impl;

import com.example.coursemanagement.models.Instructor;
import com.example.coursemanagement.models.dto.request.InstructorCreateRequest;
import com.example.coursemanagement.repositories.InstructorRepository;
import com.example.coursemanagement.services.InstructorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorServiceImpl implements InstructorService {
    private InstructorRepository instructorRepository;

    public InstructorServiceImpl(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }
    @Override
    public List<Instructor> findAllInstructors() {
        return instructorRepository.findAll();
    }

    @Override
    public Instructor findInstructorById(Long id) {
        return instructorRepository.findById(id).orElse(null);
    }

    @Override
    public Instructor createInstructor(InstructorCreateRequest req) {
        Instructor instructor = new Instructor();

        instructor.setName(req.getName());
        instructor.setEmail(req.getEmail());

        return instructorRepository.save(instructor);
    }
}
