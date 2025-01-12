package com.Akash.Student.Model;


import org.springframework.stereotype.Component;

@Component
public class Student {

    private int id;
    private String name;
    private int grade;

    public Student(int id, String name, int grade) {
        this.name = name;
        this.id=id;
        this.grade =grade;

    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
