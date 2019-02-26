package com.lambdaschool.ourcourses.controller;

import com.lambdaschool.ourcourses.model.Course;
import com.lambdaschool.ourcourses.repository.Courserepository;
import com.lambdaschool.ourcourses.repository.Instructorrepository;
import com.lambdaschool.ourcourses.repository.Studentrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.Optional;

@RestController
@RequestMapping(path = "/admin/", produces = MediaType.APPLICATION_JSON_VALUE)
public class Admincontroller
{
    //TODO Add logging when data changed
    @Autowired
    Courserepository courserepos;

    @Autowired
    Instructorrepository instructrepos;

    @Autowired
    Studentrepository studrepos;

    // puts
    //TODO finish listing and adding puts
    @PutMapping("/course/{courseid}")
    public Course changeCourseById(@RequestBody Course newcourse, @PathVariable long courseid) throws URISyntaxException
    {
        Optional<Course> updateCourse = courserepos.findById(courseid);
        if (updateCourse.isPresent())
        {
            if (newcourse.getInstructor() == null)
            {
                newcourse.setInstructor(updateCourse.get().getInstructor());
            }

            if (newcourse.getCoursename() == null)
            {
                newcourse.setCoursename(updateCourse.get().getCoursename());
            }
            newcourse.setCourseid(courseid);
            courserepos.save(newcourse);

            return newcourse;
        }
        else
        {
            return null;
        }
    }


    // posts
    //TODO List and add posts


    // delete
    //TODO finish listing and adding deletes
    @DeleteMapping("/courses/{courseid}")
    public String deleteCourseById(@PathVariable long courseid)
    {
        var foundCourse = courserepos.findById(courseid);
        if (foundCourse.isPresent())
        {
            courserepos.deleteCourseFromStudcourses(courseid);
            courserepos.deleteById(courseid);

            return "{" + "\"courseid\":"   + foundCourse.get().getCourseid() +
                         ",\"coursename\":" + "\"" + foundCourse.get().getCoursename() + "\"" +
                         ",\"instructid\":" + foundCourse.get().getInstructor().getInstructid() + "}";
        }
        else
        {
            return null;
        }
    }
}
