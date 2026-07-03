package com.example.Spring2.model;

import io.micrometer.core.instrument.Meter;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="student")
public class Student extends User {

    private int age;

    public Student() {

    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student(int age) {
        this.age = age;
    }
}
