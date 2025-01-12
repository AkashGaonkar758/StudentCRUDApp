package com.Akash.Student.Controller;

import com.Akash.Student.Model.Student;
import com.Akash.Student.Service.StudentService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")

@RestController

@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;




    @PostMapping("/add")
    public String add( @RequestBody Student student){

        studentService.addStudent(student);

        return " student added";

    }


    @DeleteMapping("/remove/{id}")
    public String remove( @PathVariable int id){

        studentService.deleteStudent(id);

        return "Student removed";

    }

    @GetMapping("/getAll")
        public List<Student> getAll(){

        return studentService.getStudents();

        }


    @PostMapping("/update")
    public String updateStudent(@RequestBody Student student){
        studentService.updateStudent(student);
        return "student updated";
    }






}
