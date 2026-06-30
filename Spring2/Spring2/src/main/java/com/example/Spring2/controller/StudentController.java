package com.example.Spring2.controller;

import com.example.Spring2.model.Student;
import com.example.Spring2.model.User;
import com.example.Spring2.serviceImpl.StudentserviceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class StudentController {

    @Autowired
    private StudentserviceImpl studentservice;

    @PostMapping
    public Student createdata(@RequestBody Student Student)
    {
        return studentservice.saveData(Student);

    }

    @GetMapping("/{id}")
    public Student getdata(@PathVariable Long id)
    {
        return studentservice.getData(id);
    }

    @DeleteMapping("/{id}")
    public String getDelete(@PathVariable Long id)
    {
        studentservice.getDelete(id);
        return "here data is deleteed : "+id;
    }

    @PutMapping("/{id}")
    public User getUpdate(@RequestBody Student student,@PathVariable Long id)
    {
        student.setId(id);
        return studentservice.saveData(student);

    }

}
