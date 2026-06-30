package com.example.Spring2.service;

import com.example.Spring2.model.Student;
import com.example.Spring2.model.User;

public interface Studentservice {

    Student saveData(Student user);
    Student getData(Long id);

    void getDelete(Long id);
}
