package com.example.coursemanagement.controllers;

import com.example.coursemanagement.models.dto.request.CourseCreateRequest;
import com.example.coursemanagement.models.dto.request.CourseUpdateRequest;
import com.example.coursemanagement.models.dto.response.ApiResponse;
import com.example.coursemanagement.models.dto.response.CourseResponse;
import com.example.coursemanagement.models.dto.response.CourseResponseV2;
import com.example.coursemanagement.models.dto.response.PageResponse;
import com.example.coursemanagement.services.CourseService;
import com.example.coursemanagement.utils.CourseStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<PageResponse<CourseResponse>>> getCourses(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size, @RequestParam(required = false) String sortBy, @RequestParam(defaultValue = "DESC") Sort.Direction direction) {

        PageResponse<CourseResponse> result = courseService.getPagedCourses(page, size, sortBy, direction);

        ApiResponse<PageResponse<CourseResponse>> response = new ApiResponse<>(true,"Ok", result);

        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<PageResponse<CourseResponse>>> getCourses(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "10") int size, @RequestParam(required = false) String sortBy, @RequestParam(defaultValue = "DESC")  Sort.Direction direction, @RequestParam(defaultValue = "ACTIVE") CourseStatus status) {
        PageResponse<CourseResponse> result = courseService.getPagedCoursesByStatus(page, size, sortBy, direction, status);

        ApiResponse<PageResponse<CourseResponse>> response = new ApiResponse<>(true,"Ok", result);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/v2")
    public ResponseEntity<ApiResponse<PageResponse<CourseResponseV2>>> getCoursesV2(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size, @RequestParam(required = false) String sortBy, @RequestParam(defaultValue = "DESC") Sort.Direction direction, @RequestParam(defaultValue = "ACTIVE") CourseStatus status) {

        PageResponse<CourseResponseV2> result = courseService.getPagedCoursesByStatusV2(page, size, sortBy, direction, status);

        ApiResponse<PageResponse<CourseResponseV2>> response = new ApiResponse<>(true,"Ok", result);

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<?>> createCourse(@RequestBody CourseCreateRequest req) {

        courseService.createCourse(req);

        ApiResponse<?> response = new ApiResponse<>(true,"Tạo khóa học thành công!",null);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> updateCourse(@PathVariable Long id,@RequestBody CourseUpdateRequest req) {

        courseService.updateCourse(id, req);

        ApiResponse<?> response = new ApiResponse<>(true,"Cập nhật khóa học thành công!",null);

        return ResponseEntity.ok(response);
    }
}