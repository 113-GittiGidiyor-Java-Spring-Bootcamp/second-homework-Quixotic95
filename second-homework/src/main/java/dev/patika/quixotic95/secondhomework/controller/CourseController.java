package dev.patika.quixotic95.secondhomework.controller;

import dev.patika.quixotic95.secondhomework.entity.Course;
import dev.patika.quixotic95.secondhomework.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CourseController {

    private CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/courses")
    public ResponseEntity<List<Course>> findAllCourses() {
        return new ResponseEntity<>(courseService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/courses/{courseId}")
    public ResponseEntity<Course> findCourseById(@PathVariable int courseId) {
        return new ResponseEntity<>(courseService.findById(courseId), HttpStatus.OK);
    }

    @PostMapping("/courses")
    public ResponseEntity<Course> saveCourse(@RequestBody Course course) {
        return new ResponseEntity<>(courseService.save(course), HttpStatus.OK);
    }

    @PutMapping("/courses")
    public ResponseEntity<Course> updateCourse(@RequestBody Course course) {
        return new ResponseEntity<>(courseService.save(course), HttpStatus.OK);
    }

    @DeleteMapping("/courses")
    public ResponseEntity<String> deleteCourse(@RequestBody Course course) {
        courseService.delete(course);
        return new ResponseEntity<>("Deleted course: " + course.toString(), HttpStatus.OK);
    }

    @DeleteMapping("/courses/{courseId}")
    public ResponseEntity<String> deleteCourse(@PathVariable int courseId) {
        courseService.deleteById(courseId);
        return new ResponseEntity<>("Deleted course id - " + courseId, HttpStatus.OK);
    }

}
