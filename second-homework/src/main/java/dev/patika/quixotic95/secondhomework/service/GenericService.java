package dev.patika.quixotic95.secondhomework.service;

import java.util.List;

public interface GenericService<T> {

    List<T> findAll();

    T findById(int id);

    T save(T entity);

    void delete(T entity);

    void deleteById(int id);

}
