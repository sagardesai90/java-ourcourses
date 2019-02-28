package com.lambdaschool.ourcourses.repository;

import com.lambdaschool.ourcourses.model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Instructorrepository extends JpaRepository<Instructor, Long>
{
    List<Instructor> findInstructorByInstructnameEquals(String name);
}

