package com.example.thirdProject.services;

import java.util.List;

public interface CrudService<E>{
    List<E> findAll();

    E findById(int id);

    E save(E entity);

    E update(E entity, int id);

    void delete(int id);
}
