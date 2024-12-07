package com.bootcamp.springBootBootcamp.service;

import com.bootcamp.springBootBootcamp.entity.Student;
import com.bootcamp.springBootBootcamp.repository.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
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
        return studentRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Student not found with this Id"+id));
    }

    public void deleteStudent(int id){
        if (!studentRepository.existsById(id)){
            throw new EntityNotFoundException("Student not found with this Id"+id);
        }
        studentRepository.deleteById(id);
    }



    public Student updateStudent(int id, Student updateStudent){
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Student not found with this id"+id));


        if (updateStudent.getName() != null){
            existingStudent.setName(updateStudent.getName());
        }

        if (updateStudent.getEmail() != null){
            existingStudent.setEmail(updateStudent.getEmail());
        }

        if (updateStudent.getCellNo() != null){
            existingStudent.setCellNo(updateStudent.getCellNo());
        }

        return studentRepository.save(existingStudent);

    }


    public void updateStudent(Student updateStudent){
        studentRepository.save(updateStudent);
    }


    public Student findStudentByEmail(String email){
        return studentRepository.findByEmail(email)
                .orElseThrow(()-> new EntityNotFoundException("Student not found with this email"+email));
    }


}
