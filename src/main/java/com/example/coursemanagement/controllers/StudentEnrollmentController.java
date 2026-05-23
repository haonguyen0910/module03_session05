package com.example.coursemanagement.controllers;

import com.example.coursemanagement.models.dto.request.StudentEnrollmentRequest;
import com.example.coursemanagement.models.dto.response.ApiResponse;
import com.example.coursemanagement.services.StudentEnrollmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students-enrollments")
public class StudentEnrollmentController {

    private StudentEnrollmentService enrollmentService;

    public StudentEnrollmentController(StudentEnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<?>> enrollStudent(@RequestBody StudentEnrollmentRequest req) {

        enrollmentService.enrollStudent(req.getStudentId(), req.getCourseId());

        ApiResponse<?> response =new ApiResponse<>(true,"Đăng ký khóa học thành công!",null);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
