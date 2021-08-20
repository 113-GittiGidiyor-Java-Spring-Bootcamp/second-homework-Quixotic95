package dev.patika.quixotic95.secondhomework.controller;

import dev.patika.quixotic95.secondhomework.entity.*;
import dev.patika.quixotic95.secondhomework.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class InstructorDemoController {

    InstructorService instructorService;

    @Autowired
    public InstructorDemoController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping("/addInstructors")
    public ResponseEntity<List<Instructor>> addExampleInstructors() {

        instructorService.save(new PermanentInstructor("Maddie", "Johnston", "Kuwait City, Kuwait", "356-1742-16", 5500));
        instructorService.save(new VisitingResearcher("William", "Ross", "Kigali, Rwanda", "820-9900-18", 200));
        instructorService.save(new PermanentInstructor("Belinda", "Riley", "Bordeaux, France", "207-2627-45", 6000));

        return new ResponseEntity<>(instructorService.findAll(), HttpStatus.OK);
    }

}
