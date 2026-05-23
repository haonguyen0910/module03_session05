package com.example.coursemanagement.controllers;

import com.example.coursemanagement.models.dto.request.StudentCreateRequest;
import com.example.coursemanagement.models.dto.response.ApiResponse;
import com.example.coursemanagement.services.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<?>> createStudent( @RequestBody StudentCreateRequest req) {

        studentService.createStudent(req);

        ApiResponse<?> response = new ApiResponse<>(true,"Tạo sinh viên thành công!",null);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
