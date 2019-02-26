package com.lambdaschool.ourcourses.controller;

import com.lambdaschool.ourcourses.model.Student;
import com.lambdaschool.ourcourses.repository.Studentrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/students/", produces = MediaType.APPLICATION_JSON_VALUE)
public class Studentcontroller
{
    @Autowired
    Studentrepository studrepos;

    @GetMapping("/students")
    public List<Student> listAllStudents()
    {
        return studrepos.findAll();
    }

    @GetMapping("/id/{studentid}")
    public List<Student> getStudentByStudentId(@PathVariable long studentid)
    {
        return studrepos.findById(studentid).stream().collect(Collectors.toList());
    }

    @GetMapping("/name/{studname}")
    public List<Student > getStudentByStudentName(@PathVariable String studname)
    {
        return studrepos.findStudentByStudnameEquals(studname);
    }
}