package com.example.Spring2.serviceImpl;

import com.example.Spring2.model.Student;
import com.example.Spring2.model.User;
import com.example.Spring2.repository.StudentRepo;
import com.example.Spring2.repository.UserRepo;
import com.example.Spring2.service.Studentservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentserviceImpl implements Studentservice {

    @Autowired
    public StudentRepo studentrepo;

    @Override
    public Student saveData(Student user) {
        return studentrepo.save(user);
    }

    @Override
    public Student getData(Long id) {
        return studentrepo.findById(id).orElse(null);
    }

    @Override
    public void getDelete(Long id) {
        studentrepo.deleteById(id);

    }
}
