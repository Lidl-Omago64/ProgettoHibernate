package org.example.repository;

import org.w3c.dom.Document;

import java.io.File;
import java.util.List;

public class XmlController<T> implements HibernateControllerInterface<T>{

    private final File file;
    private final Class<T> type;
    private Document dom;


    public XmlController(String path, Class<T> type){
        this.file = new File(path);
        this.type = type;
    }

    @Override
    public void add(T t) {
        return;
    }

    @Override
    public void remove(Integer id) {
        return;
    }

    @Override
    public List<T> getAll() {
        return List.of();
    }

    @Override
    public T getById(Integer id) {
        return null;
    }
}
