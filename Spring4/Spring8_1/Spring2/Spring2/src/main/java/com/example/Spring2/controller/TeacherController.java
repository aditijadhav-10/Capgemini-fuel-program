package com.example.Spring2.controller;

import com.example.Spring2.model.Student;
import com.example.Spring2.model.Teacher;
import com.example.Spring2.repository.TeacherRepo;
import com.example.Spring2.serviceImpl.TeacherserviceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherserviceImpl teacherservice;

    @Autowired
    private TeacherRepo teacherRepo;

    @PostMapping
    public Teacher create(@RequestBody Teacher teacher)
    {
        return teacherservice.saveTeacher(teacher);
    }

    @GetMapping("/{id}")
    public Teacher getData(@PathVariable Long id)
    {
     //   return teacherservice.getTeacher(id);
        try {
            Optional<Teacher> teacher= teacherRepo.findById(id);
            if(teacher.isPresent())
            {
                return teacher.get();
            }
            else {
                throw new RuntimeException("There is  an issue ok !! ID is not Present ok /.....");
            }

        }
        catch (RuntimeException e)
        {
            System.out.println("The Exception is :"+e.getMessage());
            return null;
        }finally {
            System.out.println("I am Always Execute ok.....");
        }
    }

    @DeleteMapping("/{id}")
    public String deleteTeacher(@PathVariable Long id) {

        try {

            Optional<Teacher> teacher = teacherRepo.findById(id);

            if (teacher.isPresent()) {

                teacherservice.deleteTeacher(id);

                return "Teacher deleted successfully.";

            }

            throw new RuntimeException("Teacher not found with ID: " + id);

        } catch (RuntimeException e) {

            return e.getMessage();

        } finally {

            System.out.println("I am always executed...");
        }
    }

    @PutMapping("/{id}")
    public Teacher getupdate(@RequestBody Teacher teacher,@PathVariable Long id)
    {
        teacher.setId(id);
        return teacherservice.saveTeacher(teacher);
    }



}
