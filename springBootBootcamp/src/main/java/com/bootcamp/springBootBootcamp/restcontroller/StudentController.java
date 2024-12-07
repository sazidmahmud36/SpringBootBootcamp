package com.bootcamp.springBootBootcamp.restcontroller;

import com.bootcamp.springBootBootcamp.entity.Student;
import com.bootcamp.springBootBootcamp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")

public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> studentsList = studentService.getAllStudents();
        return ResponseEntity.ok(studentsList);
    }


    @PostMapping("/save")
    public void saveStudent(@RequestBody Student s){
        studentService.saveStudent(s);
    }




}
