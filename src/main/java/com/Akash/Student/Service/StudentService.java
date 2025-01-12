package com.Akash.Student.Service;

import com.Akash.Student.Model.Student;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.desktop.AppReopenedEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.Akash.Student.Repository.Repo;
import org.springframework.web.bind.annotation.CrossOrigin;



@Service
public class StudentService {



    @Autowired
    private Repo studentRepo;






    public List<Student> getStudents() {
        return studentRepo.findAll();
    }

    public void addStudent(Student student) {
        studentRepo.addStudent(student);


    }

    public void deleteStudent(int ID) {
        studentRepo.deleteStudent(ID);

    }

    public void updateStudent(Student student){
        studentRepo.updateStudent(student);
        }






}
