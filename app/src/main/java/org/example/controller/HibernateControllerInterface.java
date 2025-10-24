package org.example.controller;

import java.util.List;

public interface HibernateControllerInterface <T>{

    void add(T t);

    void remove(Integer id);

    List<T> getAll();

    T getById(Integer id);

}
