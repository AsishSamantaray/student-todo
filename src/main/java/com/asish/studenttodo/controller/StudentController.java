package com.asish.studenttodo.controller;

import com.asish.studenttodo.entity.Student;
import com.asish.studenttodo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/add-student")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        return new ResponseEntity<>(studentService.addStudent(student), HttpStatus.OK);
    }

    // Controller method for Get All Students from the DB.
    @GetMapping("/get-student")
    public ResponseEntity<List<Student>> getAllStudent() {
        return new ResponseEntity<>(studentService.getAllStudent(), HttpStatus.OK);
    }
}
