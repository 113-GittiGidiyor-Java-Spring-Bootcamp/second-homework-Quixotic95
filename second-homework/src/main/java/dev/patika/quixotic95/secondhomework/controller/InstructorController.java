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

    // dependency injection with @Autowired annotation (not necessary to write, injects automatically; but placed for better-reading)
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
    public ResponseEntity<?> findInstructorById(@PathVariable int instructorId) {
        Instructor foundInstructor = instructorService.findById(instructorId);
        if (foundInstructor != null) {
            return new ResponseEntity<>(foundInstructor, HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("Instructor with id: " + instructorId + " not found.", HttpStatus.BAD_REQUEST);
        }
    }

    // add mapping for POST /instructors - add new instructor
    @PostMapping("/instructors")
    public ResponseEntity<?> saveInstructor(@RequestBody Instructor instructor) {
        if (instructorService.findById(instructor.getId()) == null) {
            return new ResponseEntity<>(instructorService.save(instructor), HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("Instructor with id: " + instructor.getId() + " already exists on database.", HttpStatus.BAD_REQUEST);
        }
    }

    // add mapping for PUT /instructors - update existing instructor
    @PutMapping("/instructors")
    public ResponseEntity<?> updateInstructor(@RequestBody Instructor instructor) {
        if (instructorService.findById(instructor.getId()) != null) {
            return new ResponseEntity<>(instructorService.save(instructor), HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("Instructor with id: " + instructor.getId() + " not found.", HttpStatus.BAD_REQUEST);
        }
    }

    // add mapping for DELETE /instructors - delete instructor
    @DeleteMapping("/instructors")
    public ResponseEntity<String> deleteInstructor(@RequestBody Instructor instructor) {
        Instructor foundInstructor = instructorService.findById(instructor.getId());
        if (foundInstructor != null) {
            instructorService.delete(instructor);
            return new ResponseEntity<>("Deleted instructor: " + foundInstructor, HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("Instructor with id: " + instructor.getId() + " not found.", HttpStatus.BAD_REQUEST);
        }
    }

    // add mapping for DELETE /instructors/{instructorId} - delete instructor by id
    @DeleteMapping("/instructors/{instructorId}")
    public ResponseEntity<String> deleteInstructor(@PathVariable int instructorId) {
        if (instructorService.findById(instructorId) != null) {
            instructorService.deleteById(instructorId);
            return new ResponseEntity<>("Deleted instructor id - " + instructorId, HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("Instructor with id: " + instructorId + " not found.", HttpStatus.BAD_REQUEST);
        }
    }

}
