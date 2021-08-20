package dev.patika.quixotic95.secondhomework.service;

import dev.patika.quixotic95.secondhomework.dao.InstructorDAO;
import dev.patika.quixotic95.secondhomework.entity.Instructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InstructorService implements GenericService<Instructor> {

    private InstructorDAO instructorDAO;

    @Autowired
    public InstructorService(InstructorDAO instructorDAO) {
        this.instructorDAO = instructorDAO;
    }

    @Override
    @Transactional
    public List<Instructor> findAll() {
        return instructorDAO.findAll();
    }

    @Override
    @Transactional
    public Instructor findById(int instructorId) {
        return instructorDAO.findById(instructorId);
    }

    @Override
    @Transactional
    public Instructor save(Instructor instructor) {
        return instructorDAO.save(instructor);
    }

    @Override
    @Transactional
    public void delete(Instructor instructor) {
        instructorDAO.delete(instructor);
    }

    @Override
    @Transactional
    public void deleteById(int instructorId) {
        instructorDAO.deleteById(instructorId);
    }

}
