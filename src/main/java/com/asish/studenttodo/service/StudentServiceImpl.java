package com.asish.studenttodo.service;

import com.asish.studenttodo.entity.Student;
import com.asish.studenttodo.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student addStudent(Student student) {
        studentRepository.save(student);
        return student;
    }
}
