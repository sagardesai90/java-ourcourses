package com.lambdaschool.ourcourses.repository;

import com.lambdaschool.ourcourses.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Studentrepository extends JpaRepository<Student, Long>
{
    List<Student> findStudentByStudnameEquals(String name);
}
