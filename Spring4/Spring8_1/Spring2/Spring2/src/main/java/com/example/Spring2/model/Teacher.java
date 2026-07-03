package com.example.Spring2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="teacher")
public class Teacher extends User {

    private String subject;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
