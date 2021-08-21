package dev.patika.quixotic95.secondhomework.dao;

import dev.patika.quixotic95.secondhomework.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class StudentDAOJPAImpl implements StudentDAO {

    // define field for EntityManager
    private final EntityManager entityManager;

    // set up constructor injection
    @Autowired
    public StudentDAOJPAImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Student> findAll() {
        // create a query & execute query and get result list & return the results
        return entityManager.createQuery("FROM Student s", Student.class).getResultList();
    }

    @Override
    public Student findById(int id) {
        // find and return Student
        return entityManager.find(Student.class, id);
    }

    @Override
    public Student save(Student entity) {
        // save and return the saved Student
        return entityManager.merge(entity);
    }

    @Override
    public void delete(Student entity) {
        entityManager.remove(entityManager.getReference(Student.class, entity.getId()));
    }

    @Override
    public void deleteById(int id) {
        Student entity = findById(id);
        entityManager.remove(entity);
    }

}
