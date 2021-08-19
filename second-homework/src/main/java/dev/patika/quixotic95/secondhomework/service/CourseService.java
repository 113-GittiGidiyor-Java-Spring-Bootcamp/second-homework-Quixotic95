package dev.patika.quixotic95.secondhomework.service;

import dev.patika.quixotic95.secondhomework.dao.CourseDAO;
import dev.patika.quixotic95.secondhomework.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CourseService implements GenericService<Course> {

    CourseDAO courseDAO;

    @Autowired
    public CourseService(CourseDAO courseDAO) {
        this.courseDAO = courseDAO;
    }

    @Override
    @Transactional
    public List<Course> findAll() {
        return courseDAO.findAll();
    }

    @Override
    @Transactional
    public Course findById(int courseId) {
        return courseDAO.findById(courseId);
    }

    @Override
    @Transactional
    public Course save(Course course) {
        return courseDAO.save(course);
    }

    @Override
    @Transactional
    public void delete(Course course) {
        courseDAO.delete(course);
    }

    @Override
    @Transactional
    public void deleteById(int courseId) {
        courseDAO.deleteById(courseId);
    }
}
