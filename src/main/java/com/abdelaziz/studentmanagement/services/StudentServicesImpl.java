package com.abdelaziz.studentmanagement.services;

import com.abdelaziz.studentmanagement.dao.StudentRepository;
import com.abdelaziz.studentmanagement.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServicesImpl implements StudentServices{

    // define StudentRepository field to do constructor Injection:
    private StudentRepository studentRepository ;

    // constructor Injection:
    @Autowired
    public StudentServicesImpl(StudentRepository studentRepository)
    {
        this.studentRepository = studentRepository ;
    }

    @Override
    public List<Student> findAll() {
       return studentRepository.findAll();
    }
    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteById(int theId) {
        studentRepository.deleteById(theId);
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student findStudentById(int theId) {
        return studentRepository.findById(theId).get();
    }

}
