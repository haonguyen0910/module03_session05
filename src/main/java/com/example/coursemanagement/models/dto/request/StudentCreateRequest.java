package com.example.coursemanagement.models.dto.request;

public class StudentCreateRequest {
    private String name;
    private String email;

    public StudentCreateRequest() {
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
