package com.example.coursemanagement.services.impl;

import com.example.coursemanagement.models.Course;
import com.example.coursemanagement.models.Student;
import com.example.coursemanagement.models.StudentEnrollment;
import com.example.coursemanagement.repositories.CourseRepository;
import com.example.coursemanagement.repositories.StudentEnrollmentRepository;
import com.example.coursemanagement.repositories.StudentRepository;
import com.example.coursemanagement.services.StudentEnrollmentService;
import org.springframework.stereotype.Service;

@Service
public class StudentEnrollmentServiceImpl implements StudentEnrollmentService {
    private StudentRepository studentRepository;
    private CourseRepository courseRepository;
    private StudentEnrollmentRepository enrollmentRepository;

    public StudentEnrollmentServiceImpl(StudentRepository studentRepository, CourseRepository courseRepository, StudentEnrollmentRepository enrollmentRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.enrollmentRepository = enrollmentRepository;
    }

    @Override
    public void enrollStudent(Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new RuntimeException("Student không tồn tại"));

        Course course = courseRepository.findById(courseId).orElseThrow(() -> new RuntimeException("Course không tồn tại"));

        StudentEnrollment enrollment = new StudentEnrollment();

        enrollment.setStudent(student);
        enrollment.setCourse(course);

        enrollmentRepository.save(enrollment);
    }
}
