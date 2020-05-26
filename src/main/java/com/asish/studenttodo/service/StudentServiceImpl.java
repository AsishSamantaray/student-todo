package com.asish.studenttodo.service;

import com.asish.studenttodo.entity.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Override
    public Student addStudent(Student student) {
        return student;
    }
}
