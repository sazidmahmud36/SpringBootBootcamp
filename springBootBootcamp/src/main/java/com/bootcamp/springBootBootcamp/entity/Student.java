package com.bootcamp.springBootBootcamp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "students")


public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 30, nullable = false)
    private String name;
    private String email;
    private String cellNo;


    public Student() {
    }

    public Student(int id, String name, String email, String cellNo) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.cellNo = cellNo;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCellNo() {
        return cellNo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCellNo(String cellNo) {
        this.cellNo = cellNo;
    }
}
