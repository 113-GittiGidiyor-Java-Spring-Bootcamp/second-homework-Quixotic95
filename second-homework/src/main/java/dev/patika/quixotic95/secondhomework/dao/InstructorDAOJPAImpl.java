package dev.patika.quixotic95.secondhomework.dao;

import dev.patika.quixotic95.secondhomework.entity.Instructor;
import dev.patika.quixotic95.secondhomework.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class InstructorDAOJPAImpl implements InstructorDAO{

    private EntityManager entityManager;

    @Autowired
    public InstructorDAOJPAImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Instructor> findAll() {
        return entityManager.createQuery("FROM Instructor i", Instructor.class).getResultList();
    }

    @Override
    public Instructor findById(int id) {
        return entityManager.find(Instructor.class, id);
    }

    @Override
    public Instructor save(Instructor entity) {
        return entityManager.merge(entity);
    }

    @Override
    public void delete(Instructor entity) {
        entityManager.remove(save(entity));
    }

    @Override
    public void deleteById(int id) {
        Instructor entity = findById(id);
        entityManager.remove(entity);
    }
}
