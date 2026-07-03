package com.example.Spring2.controller;

import com.example.Spring2.model.Student;
import com.example.Spring2.model.User;
import com.example.Spring2.repository.StudentRepo;
import com.example.Spring2.serviceImpl.StudentserviceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentserviceImpl studentservice;

    @Autowired
    private StudentRepo studentRepo;

    @PostMapping
    public Student createdata(@RequestBody Student Student)
    {
        return studentservice.saveStudent(Student);

    }

    @GetMapping("/{id}")
    public Student getdata(@PathVariable Long id)
    {
        // return studentservice.getStudent(id);
        //But Instead of this we can use this one also

        try
        {
            Optional<Student> student=studentRepo.findById(id);
            if(student.isPresent())
            {
                return student.get();
            }
            throw new RuntimeException("Here data is not found of that Student :"+id);
        }catch (RuntimeException e)
        {
            System.out.println("The Exception is :"+e.getMessage());
            return null;
        }finally {
            System.out.println("I am always Executed .... ");
        }

    }



    @DeleteMapping("/{id}")
    public String getDelete(@PathVariable Long id)
    {
       // studentservice.deleteStudent(id);
      //  return "-------- Here data is deleteed --------------  : "+id;
        try
        {
            Optional<Student> student=studentRepo.findById(id);
            if(student.isPresent())
            {
                studentservice.deleteStudent(id);
                return "The Data is deleted Successfully :"+id;
            }
            throw new RuntimeException("Here data is not found of that Student :"+id);
        }catch (RuntimeException e)
        {
            System.out.println("The Exception is :"+e.getMessage());
            return null;
        }finally {
            System.out.println(" I am from getDelete methods --- i am always Executed .... ");
        }
    }



    @PutMapping("/{id}")
    public User getUpdate(@RequestBody Student student,@PathVariable Long id)
    {
        student.setId(id);
        return studentservice.saveStudent(student);

    }

}
