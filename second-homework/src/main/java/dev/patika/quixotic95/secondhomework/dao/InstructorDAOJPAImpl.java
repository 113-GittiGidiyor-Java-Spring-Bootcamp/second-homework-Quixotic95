package dev.patika.quixotic95.secondhomework.dao;

import dev.patika.quixotic95.secondhomework.entity.Instructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class InstructorDAOJPAImpl implements InstructorDAO {

    // define field for EntityManager
    private final EntityManager entityManager;

    // set up constructor injection
    @Autowired
    public InstructorDAOJPAImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Instructor> findAll() {
        // create a query & execute query and get result list & return the results
        return entityManager.createQuery("FROM Instructor i", Instructor.class).getResultList();
    }

    @Override
    public Instructor findById(int id) {
        // find and return Instructor
        return entityManager.find(Instructor.class, id);
    }

    @Override
    public Instructor save(Instructor entity) {
        // save and return the saved Instructor
        return entityManager.merge(entity);
    }

    @Override
    public void delete(Instructor entity) {
        entityManager.remove(entityManager.getReference(Instructor.class, entity.getId()));
    }

    @Override
    public void deleteById(int id) {
        Instructor entity = findById(id);
        entityManager.remove(entity);
    }

}
