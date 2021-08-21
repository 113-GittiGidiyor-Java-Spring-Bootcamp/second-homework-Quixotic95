package dev.patika.quixotic95.secondhomework.controller;

import dev.patika.quixotic95.secondhomework.entity.Gender;
import dev.patika.quixotic95.secondhomework.entity.Student;
import dev.patika.quixotic95.secondhomework.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentDemoController {

    private final StudentService studentService;

    @Autowired
    public StudentDemoController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/addStudents")
    public ResponseEntity<List<Student>> addExampleStudents() {

        studentService.save(new Student("Ahmet Emre", "Oguz", "Istanbul, Turkey", LocalDate.of(1995, Month.JULY, 26), Gender.MALE));
        studentService.save(new Student("Edwin", "Bailey", "Ottawa, Canada", LocalDate.of(1991, Month.MAY, 5), Gender.OTHER));
        studentService.save(new Student("Henry", "Elliott", "San Juan, Puerto Rico", LocalDate.of(2002, Month.AUGUST, 19), Gender.MALE));
        studentService.save(new Student("Brad", "Johnson", "Yokohama, Japan", LocalDate.of(1998, Month.AUGUST, 4), Gender.MALE));
        studentService.save(new Student("Ada", "Richards", "Yerevan, Armenia", LocalDate.of(1995, Month.DECEMBER, 13), Gender.FEMALE));
        studentService.save(new Student("Olivia", "Parker", "Gaborone, Botswana", LocalDate.of(2001, Month.APRIL, 22), Gender.FEMALE));

        return new ResponseEntity<>(studentService.findAll(), HttpStatus.OK);
    }

}
