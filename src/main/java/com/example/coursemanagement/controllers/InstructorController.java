package com.example.coursemanagement.controllers;

import com.example.coursemanagement.models.Instructor;
import com.example.coursemanagement.models.dto.request.InstructorCreateRequest;
import com.example.coursemanagement.models.dto.response.ApiResponse;
import com.example.coursemanagement.services.InstructorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instructors")
public class InstructorController {

    private InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Instructor>>> getAllInstructors() {

        List<Instructor> instructors = instructorService.findAllInstructors();

        ApiResponse<List<Instructor>> response = new ApiResponse<>(true,"Lấy danh sách giảng viên thành công!",instructors);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> getInstructorById(@PathVariable Long id) {
        Instructor instructor = instructorService.findInstructorById(id);

        if (instructor == null) {

            ApiResponse<?> response =new ApiResponse<>(false,"Instructor không tìm thấy!", null);

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

        ApiResponse<Instructor> response =new ApiResponse<>(true,"Lấy giảng viên thành công!",instructor);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<?>> createInstructor(@RequestBody InstructorCreateRequest req) {

        Instructor instructor = instructorService.createInstructor(req);

        ApiResponse<Instructor> response =  new ApiResponse<>(true,"Tạo giảng viên thành công!",instructor);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}