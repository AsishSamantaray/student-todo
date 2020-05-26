package com.asish.studenttodo.controller;

import com.asish.studenttodo.entity.Student;
import com.asish.studenttodo.service.StudentService;
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

    // Controller method for Get a particular Student of given ID from the DB.
    @GetMapping("/get-student/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable long id) {
        return new ResponseEntity<>(studentService.getStudent(id), HttpStatus.OK);
    }

    // Controller method for Update a particular Student of given ID.
    @PutMapping("/update-student/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable long id, @RequestBody Student student) {
        return new ResponseEntity<>(studentService.updateStudent(id, student), HttpStatus.OK);
    }

}
