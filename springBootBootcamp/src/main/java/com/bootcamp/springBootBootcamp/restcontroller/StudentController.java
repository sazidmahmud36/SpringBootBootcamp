package com.bootcamp.springBootBootcamp.restcontroller;

import com.bootcamp.springBootBootcamp.entity.Student;
import com.bootcamp.springBootBootcamp.service.StudentService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<String> saveStudent(@RequestBody Student s){
        studentService.saveStudent(s);
        return new ResponseEntity<>("Student Saved Successfully", HttpStatus.CREATED);
    }




    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id){
        try {
            studentService.deleteStudent(id);
            return ResponseEntity.ok("Student with this id: "+id+" has been deleted");
        }catch (EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student s){
        Student updateStudent = studentService.updateStudent(id, s);
        return ResponseEntity.ok(updateStudent);
    }


    @GetMapping("/{email}")
    public ResponseEntity<Student> findStudentByEmail(@PathVariable String email){
        Student findStudentByEmail = studentService.findStudentByEmail(email);
        return ResponseEntity.ok(findStudentByEmail);

    }




}
