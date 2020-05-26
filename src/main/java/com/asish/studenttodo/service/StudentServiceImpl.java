package com.asish.studenttodo.service;

import com.asish.studenttodo.entity.Student;
import com.asish.studenttodo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student addStudent(Student student) {
        if (studentRepository.findByEmail(student.getEmail()) != null) {
            throw new RuntimeException("Record already exists..");
        }
        studentRepository.save(student);
        return student;
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudent(long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.valueOf(id)));
    }

    @Override
    public Student updateStudent(long id, Student student) {
        Optional<Student> studentRepositoryById = studentRepository.findById(id);
        if (studentRepositoryById.isPresent()) {
            Student s = studentRepositoryById.get();
            s.setEmail(student.getEmail());
            s.setFirstName(student.getFirstName());
            s.setBranch(student.getBranch());
            s.setLastName(student.getLastName());
            studentRepository.save(s);
        }
        return studentRepositoryById
                .orElseThrow(() -> new EntityNotFoundException(String.valueOf(id)));
    }

    @Override
    public boolean deleteStudent(long id) {
        Optional<Student> studentRepositoryById = studentRepository.findById(id);
        boolean res = false;
        if (studentRepositoryById.isPresent()) {
            Student student = studentRepositoryById.get();
            studentRepository.delete(student);
            res = true;
        }
        return res;
    }
}
