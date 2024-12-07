package com.bootcamp.springBootBootcamp.service;

import com.bootcamp.springBootBootcamp.entity.Student;
import com.bootcamp.springBootBootcamp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public void saveStudent(Student s){
        studentRepository.save(s);
    }

    public Student getStudentById(int id){
        return studentRepository.findById(id).get();
    }

}
