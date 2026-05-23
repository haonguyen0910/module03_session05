package com.example.coursemanagement.services.impl;

import com.example.coursemanagement.models.Course;
import com.example.coursemanagement.models.Instructor;
import com.example.coursemanagement.models.dto.request.CourseCreateRequest;
import com.example.coursemanagement.models.dto.request.CourseUpdateRequest;
import com.example.coursemanagement.models.dto.response.CourseResponse;
import com.example.coursemanagement.models.dto.response.PageResponse;
import com.example.coursemanagement.repositories.CourseRepository;
import com.example.coursemanagement.repositories.InstructorRepository;
import com.example.coursemanagement.services.CourseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {

    private CourseRepository courseRepository;
    private InstructorRepository instructorRepository;

    public CourseServiceImpl(CourseRepository courseRepository, InstructorRepository instructorRepository) {
        this.courseRepository = courseRepository;
        this.instructorRepository = instructorRepository;
    }

    @Override
    public void createCourse(CourseCreateRequest req) {
        Instructor instructor = instructorRepository.findById(req.getInstructorId()).orElseThrow(() -> new RuntimeException("Instructor không tồn tại"));

        Course course = new Course();

        course.setTitle(req.getTitle());
        course.setStatus(req.getStatus());
        course.setInstructor(instructor);

        courseRepository.save(course);
    }

    @Override
    public void updateCourse(Long id, CourseUpdateRequest req) {
        Course course = courseRepository.findById(id).orElseThrow(() -> new RuntimeException("Course không tồn tại"));

        Instructor instructor = instructorRepository.findById(req.getInstructorId()).orElseThrow(() -> new RuntimeException("Instructor không tồn tại"));

        course.setTitle(req.getTitle());
        course.setStatus(req.getStatus());
        course.setInstructor(instructor);

        courseRepository.save(course);
    }

    @Override
    public PageResponse<CourseResponse> getPagedCourses(int page, int size, String sortBy, Sort.Direction direction) {
        if (page < 0) {
            page = 0;
        }

        if (sortBy == null || sortBy.isBlank()) {
            sortBy = "id";
        }

        Sort sort = Sort.by(direction, sortBy);

        Pageable pageable = PageRequest.of(page, size, sort);

        Page<Course> coursePage = courseRepository.findAll(pageable);

        Page<CourseResponse> responsePage = coursePage.map(this::mapToResponse);

        PageResponse<CourseResponse> pageResponse = new PageResponse<>();

        pageResponse.setItems(responsePage.getContent());

        pageResponse.setPage(responsePage.getNumber());

        pageResponse.setSize(responsePage.getSize());

        pageResponse.setTotalItems(responsePage.getTotalElements());

        pageResponse.setTotalPages(responsePage.getTotalPages());

        pageResponse.setLast(responsePage.isLast());

        return pageResponse;
    }

    private CourseResponse mapToResponse(Course course) {

        CourseResponse response = new CourseResponse();

        response.setId(course.getId());
        response.setTitle(course.getTitle());
        response.setStatus(course.getStatus());

        return response;
    }
}
