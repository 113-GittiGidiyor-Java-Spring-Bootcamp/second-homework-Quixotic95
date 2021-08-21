package dev.patika.quixotic95.secondhomework.dao;

import dev.patika.quixotic95.secondhomework.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CourseDAOJPAImpl implements CourseDAO {

    // define field for EntityManager
    private final EntityManager entityManager;

    // set up constructor injection
    @Autowired
    public CourseDAOJPAImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Course> findAll() {
        // create a query & execute query and get result list & return the results
        return entityManager.createQuery("FROM Course c", Course.class).getResultList();
    }

    @Override
    public Course findById(int id) {
        // find and return Course
        return entityManager.find(Course.class, id);
    }

    @Override
    public Course save(Course entity) {
        // save and return the saved Course
        return entityManager.merge(entity);
    }

    @Override
    public void delete(Course entity) {
        entityManager.remove(entityManager.getReference(Course.class, entity.getId()));
    }

    @Override
    public void deleteById(int id) {
        Course entity = findById(id);
        entityManager.remove(entity);
    }

}
