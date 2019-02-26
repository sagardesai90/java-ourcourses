package com.lambdaschool.ourcourses.controller;

import com.lambdaschool.ourcourses.model.Instructor;
import com.lambdaschool.ourcourses.repository.Instructorrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/instructors/", produces = MediaType.APPLICATION_JSON_VALUE)
public class Instructorcontroller
{
    @Autowired
    Instructorrepository instructrepos;

    @GetMapping(value = "/instructors")
    public List<Instructor> listAllInstructors()
    {
        return instructrepos.findAll();
    }

    @GetMapping(value = "/id/{instructorid}")
    public List<Instructor> getInstructorByInstructorId(@PathVariable long instructorid)
    {
        return instructrepos.findById(instructorid).stream().collect(Collectors.toList());
    }

    @GetMapping(value = "/name/{instructorname}")
    public List<Instructor> getInstructorByInstructorName(@PathVariable String instructorname)
    {
        return instructrepos.findInstructorByInstructnameEquals(instructorname);
    }
}
