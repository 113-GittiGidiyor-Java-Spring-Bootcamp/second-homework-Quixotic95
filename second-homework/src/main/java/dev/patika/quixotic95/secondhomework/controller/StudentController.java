package dev.patika.quixotic95.secondhomework.controller;

import dev.patika.quixotic95.secondhomework.entity.Student;
import dev.patika.quixotic95.secondhomework.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // expose "/students" and return list of students
    @GetMapping("/students")
    public ResponseEntity<List<Student>> findAllStudents() {
        return new ResponseEntity<>(studentService.findAll(), HttpStatus.OK);
    }

    // add mapping for GET /students/{studentId} to get a student by id
    @GetMapping("/students/{studentId}")
    public ResponseEntity<Student> findStudentById(@PathVariable int studentId) {
        return new ResponseEntity<>(studentService.findById(studentId), HttpStatus.OK);
    }

    // add mapping for POST /students - add new student
    @PostMapping("/students")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
        return new ResponseEntity<>(studentService.save(student), HttpStatus.OK);
    }

    // add mapping for PUT /students - update existing student
    @PutMapping("/students")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
        return new ResponseEntity<>(studentService.save(student), HttpStatus.OK);
    }

    // add mapping for DELETE /students - delete student
    @DeleteMapping("/students")
    public ResponseEntity<String> deleteStudent(@RequestBody Student student) {
        studentService.delete(student);
        return new ResponseEntity<>("Deleted student: " + student.toString(), HttpStatus.OK);
    }

    // add mapping for DELETE /students/{studentId} - delete student by id
    @DeleteMapping("/students/{studentId}")
    public ResponseEntity<String> deleteStudent(@PathVariable int studentId) {
        studentService.deleteById(studentId);
        return new ResponseEntity<>("Deleted student id - " + studentId, HttpStatus.OK);
    }

}
