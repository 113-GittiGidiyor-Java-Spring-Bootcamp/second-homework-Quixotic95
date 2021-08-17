package dev.patika.quixotic95.secondhomework.dao;

import java.util.List;

public interface GenericDAO<T> {

    List<T> findAll();

    T findById(int id);

    T save(T entity);

    void delete(T entity);

    void deleteById(int id);

}
