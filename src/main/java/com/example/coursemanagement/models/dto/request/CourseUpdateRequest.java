package com.example.coursemanagement.models.dto.request;

import com.example.coursemanagement.utils.CourseStatus;

public class CourseUpdateRequest {
    private String title;
    private CourseStatus status;
    private Long instructorId;

    public CourseUpdateRequest() {
    }

    public String getTitle() {
        return title;
    }

    public CourseStatus getStatus() {
        return status;
    }

    public Long getInstructorId() {
        return instructorId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setStatus(CourseStatus status) {
        this.status = status;
    }

    public void setInstructorId(Long instructorId) {
        this.instructorId = instructorId;
    }
}
