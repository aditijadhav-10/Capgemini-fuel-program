package com.example.Spring2.service;

import com.example.Spring2.model.Teacher;
import org.apache.juli.logging.Log;

public interface TeacherService {

    Teacher saveTeacher(Teacher teacher);

    Teacher getTeacher(Long id);

    void deleteTeacher(Long id);
}
