package com.abdelaziz.studentmanagement.services;

import com.abdelaziz.studentmanagement.entity.Student;

import java.util.List;

public interface StudentServices {

    List<Student> findAll();

    Student save(Student student);

    void deleteById(int theId);

    Student updateStudent(Student student);

    Student findStudentById(int theId);
}
