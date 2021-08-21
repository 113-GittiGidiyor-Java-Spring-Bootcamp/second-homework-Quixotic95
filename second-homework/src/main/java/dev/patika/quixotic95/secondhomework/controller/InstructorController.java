package dev.patika.quixotic95.secondhomework.controller;

import dev.patika.quixotic95.secondhomework.entity.Instructor;
import dev.patika.quixotic95.secondhomework.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class InstructorController {

    private final InstructorService instructorService;

    @Autowired
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    // expose "/instructors" and return list of instructors
    @GetMapping("/instructors")
    public ResponseEntity<List<Instructor>> findAllInstructors() {
        return new ResponseEntity<>(instructorService.findAll(), HttpStatus.OK);
    }

    // add mapping for GET /instructors/{instructorId} to get an instructor by id
    @GetMapping("/instructors/{instructorId}")
    public ResponseEntity<Instructor> findInstructorById(@PathVariable int instructorId) {
        return new ResponseEntity<>(instructorService.findById(instructorId), HttpStatus.OK);
    }

    // add mapping for POST /instructors - add new instructor
    @PostMapping("/instructors")
    public ResponseEntity<Instructor> saveInstructor(@RequestBody Instructor instructor) {
        return new ResponseEntity<>(instructorService.save(instructor), HttpStatus.OK);
    }

    // add mapping for PUT /instructors - update existing instructor
    @PutMapping("/instructors")
    public ResponseEntity<Instructor> updateInstructor(@RequestBody Instructor instructor) {
        return new ResponseEntity<>(instructorService.save(instructor), HttpStatus.OK);
    }

    // add mapping for DELETE /instructors - delete instructor
    @DeleteMapping("/instructors")
    public ResponseEntity<String> deleteInstructor(@RequestBody Instructor instructor) {
        instructorService.delete(instructor);
        return new ResponseEntity<>("Deleted instructor: " + instructor.toString(), HttpStatus.OK);
    }

    // add mapping for DELETE /instructors/{instructorId} - delete instructor by id
    @DeleteMapping("/instructors/{instructorId}")
    public ResponseEntity<String> deleteInstructor(@PathVariable int instructorId) {
        instructorService.deleteById(instructorId);
        return new ResponseEntity<>("Deleted instructor id - " + instructorId, HttpStatus.OK);
    }

}
