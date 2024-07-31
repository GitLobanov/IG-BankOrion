package com.backend.repository;

import org.hibernate.dialect.unique.CreateTableUniqueDelegate;

import java.util.List;

public interface CrudRepository <T,ID>  {

    boolean save(T t);
    void update(T t);
    void delete(T t);
    void saves(List<T> list);
    T findById(ID id);
    List<T> findAll();


}
