package com.example.coursemanagement.services;

import com.example.coursemanagement.models.dto.request.CourseCreateRequest;
import com.example.coursemanagement.models.dto.request.CourseUpdateRequest;
import com.example.coursemanagement.models.dto.response.CourseResponse;
import com.example.coursemanagement.models.dto.response.PageResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

public interface CourseService {
    void createCourse(CourseCreateRequest req);
    void updateCourse(Long id, CourseUpdateRequest req);
    PageResponse<CourseResponse> getPagedCourses(int page, int size, String sortBy, Sort.Direction direction);
}
