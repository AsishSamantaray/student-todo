package com.asish.studenttodo.service;

import com.asish.studenttodo.entity.Student;

import java.util.List;

public interface StudentService {
    Student addStudent(Student student);

    List<Student> getAllStudent();

    Student getStudent(long id);

    Student updateStudent(long id, Student student);

    boolean deleteStudent(long id);
}
