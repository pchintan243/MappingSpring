package com.mapping.maptut.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mapping.maptut.entities.CreateStudent;
import com.mapping.maptut.entities.Student;
import com.mapping.maptut.services.StudentService;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/create-student")
    public ResponseEntity<Student> createStudent(@RequestBody CreateStudent student) {
        Student studentData = studentService.createStudent(student);
        if (studentData == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(studentData);
    }

    @GetMapping("/getallstudents")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> allStudents = studentService.getAllStudents();
        return ResponseEntity.of(Optional.of(allStudents));
    }
}
