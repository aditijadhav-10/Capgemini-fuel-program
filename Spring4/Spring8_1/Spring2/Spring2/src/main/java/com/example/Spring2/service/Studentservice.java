package com.example.Spring2.service;

import com.example.Spring2.model.Student;
import com.example.Spring2.model.User;

public interface Studentservice {

    Student saveStudent(Student student);

    Student getStudent(Long id);

    void deleteStudent(Long id);
}
