package com.example.coursemanagement.models.dto.request;

public class StudentEnrollmentRequest {
    private Long studentId;
    private Long courseId;

    public StudentEnrollmentRequest() {
    }

    public Long getStudentId() {
        return studentId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }
}
