package dev.patika.quixotic95.secondhomework.controller;

import dev.patika.quixotic95.secondhomework.entity.Course;
import dev.patika.quixotic95.secondhomework.entity.Instructor;
import dev.patika.quixotic95.secondhomework.entity.PermanentInstructor;
import dev.patika.quixotic95.secondhomework.entity.VisitingResearcher;
import dev.patika.quixotic95.secondhomework.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CourseDemoController {

    private CourseService courseService;

    @Autowired
    public CourseDemoController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/addCourses")
    public ResponseEntity<List<Course>> addExampleCourses() {

        courseService.save(new Course("Turkish Language - 1", "TDL1001", 2));
        courseService.save(new Course("Ataturk’s Principles and Turkish Revolution History", "ATA1001", 3));
        courseService.save(new Course("Basic Art Education", "MTP1001", 4));
        courseService.save(new Course("Fashion Picture and Illustration", "MTP1005", 5));
        
        return new ResponseEntity<>(courseService.findAll(), HttpStatus.OK);
    }
}
