package dev.patika.quixotic95.secondhomework.service;

import dev.patika.quixotic95.secondhomework.dao.StudentDAO;
import dev.patika.quixotic95.secondhomework.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService implements GenericService<Student> {

    private final StudentDAO studentDAO;

    @Autowired
    public StudentService(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    @Transactional
    public List<Student> findAll() {
        return studentDAO.findAll();
    }

    @Override
    @Transactional
    public Student findById(int studentId) {
        return studentDAO.findById(studentId);
    }

    @Override
    @Transactional
    public Student save(Student student) {
        return studentDAO.save(student);
    }

    @Override
    @Transactional
    public void delete(Student student) {
        studentDAO.delete(student);
    }

    @Override
    @Transactional
    public void deleteById(int studentId) {
        studentDAO.deleteById(studentId);
    }

}
