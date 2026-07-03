package com.example.Spring2.serviceImpl;

import com.example.Spring2.model.Teacher;
import com.example.Spring2.repository.TeacherRepo;
import com.example.Spring2.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherserviceImpl implements TeacherService {

    @Autowired
    private TeacherRepo teacherRepo;

    @Override
    public Teacher saveTeacher(Teacher teacher) {
        return teacherRepo.save(teacher);
    }

    @Override
    public Teacher getTeacher(Long id) {
        return teacherRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteTeacher(Long id) {
        teacherRepo.deleteById(id);

    }
}
