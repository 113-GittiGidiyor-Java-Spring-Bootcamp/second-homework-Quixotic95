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

    // dependency injection with @Autowired annotation (not necessary to write, injects automatically; but placed for better-reading)
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
    public ResponseEntity<?> findStudentById(@PathVariable int studentId) {
        Student foundStudent = studentService.findById(studentId);
        if (foundStudent != null) {
            return new ResponseEntity<>(foundStudent, HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("Student with id: " + studentId + " not found.", HttpStatus.BAD_REQUEST);
        }
    }

    // add mapping for POST /students - add new student
    @PostMapping("/students")
    public ResponseEntity<?> saveStudent(@RequestBody Student student) {
        if (studentService.findById(student.getId()) == null) {
            return new ResponseEntity<>(studentService.save(student), HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("Student with id: " + student.getId() + " already exists on database.", HttpStatus.BAD_REQUEST);
        }
    }

    // add mapping for PUT /students - update existing student
    @PutMapping("/students")
    public ResponseEntity<?> updateStudent(@RequestBody Student student) {
        if (studentService.findById(student.getId()) != null) {
            return new ResponseEntity<>(studentService.save(student), HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("Student with id: " + student.getId() + " not found.", HttpStatus.BAD_REQUEST);
        }
    }

    // add mapping for DELETE /students - delete student
    @DeleteMapping("/students")
    public ResponseEntity<String> deleteStudent(@RequestBody Student student) {
        Student foundStudent = studentService.findById(student.getId());
        if (foundStudent != null) {
            studentService.delete(student);
            return new ResponseEntity<>("Deleted student: " + foundStudent, HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("Student with id: " + student.getId() + " not found.", HttpStatus.BAD_REQUEST);
        }
    }

    // add mapping for DELETE /students/{studentId} - delete student by id
    @DeleteMapping("/students/{studentId}")
    public ResponseEntity<String> deleteStudent(@PathVariable int studentId) {
        if (studentService.findById(studentId) != null) {
            studentService.deleteById(studentId);
            return new ResponseEntity<>("Deleted student id - " + studentId, HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("Student with id: " + studentId + " not found.", HttpStatus.BAD_REQUEST);
        }
    }

}
