package com.abdelaziz.studentmanagement.dao;

import com.abdelaziz.studentmanagement.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student , Integer> {

    // that's it
}
