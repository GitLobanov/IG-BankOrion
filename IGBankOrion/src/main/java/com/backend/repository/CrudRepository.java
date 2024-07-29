package com.backend.repository;

import org.hibernate.dialect.unique.CreateTableUniqueDelegate;

import java.util.List;

public interface CrudRepository <T,ID>  {

    void save(T t);
    void update(T t);
    void delete(T t);
    T findById(ID id);
    List<T> findAll();

}
