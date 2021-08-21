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

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    // expose "/courses" and return list of courses
    @GetMapping("/courses")
    public ResponseEntity<List<Course>> findAllCourses() {
        return new ResponseEntity<>(courseService.findAll(), HttpStatus.OK);
    }

    // add mapping for GET /courses/{courseId} to get a course by id
    @GetMapping("/courses/{courseId}")
    public ResponseEntity<Course> findCourseById(@PathVariable int courseId) {
        return new ResponseEntity<>(courseService.findById(courseId), HttpStatus.OK);
    }

    // add mapping for POST /courses - add new course
    @PostMapping("/courses")
    public ResponseEntity<Course> saveCourse(@RequestBody Course course) {
        return new ResponseEntity<>(courseService.save(course), HttpStatus.OK);
    }

    // add mapping for PUT /courses - update existing course
    @PutMapping("/courses")
    public ResponseEntity<Course> updateCourse(@RequestBody Course course) {
//        if(courseService.findById(course.getId()) == null) {
            return new ResponseEntity<>(courseService.save(course), HttpStatus.OK);
//        } else {
//            return new ResponseEntity<String>("Course with id: " + course.getId() + " not found.", HttpStatus.BAD_REQUEST);
//        }

    }

    // add mapping for DELETE /courses - delete course
    @DeleteMapping("/courses")
    public ResponseEntity<String> deleteCourse(@RequestBody Course course) {
        courseService.delete(course);
        return new ResponseEntity<>("Deleted course: " + course.toString(), HttpStatus.OK);
    }

    // add mapping for DELETE /courses/{courseId} - delete course by id
    @DeleteMapping("/courses/{courseId}")
    public ResponseEntity<String> deleteCourse(@PathVariable int courseId) {
        courseService.deleteById(courseId);
        return new ResponseEntity<>("Deleted course id - " + courseId, HttpStatus.OK);
    }

}
