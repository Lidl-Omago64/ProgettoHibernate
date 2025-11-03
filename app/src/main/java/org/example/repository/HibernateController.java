package org.example.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;


public class HibernateController<T> implements HibernateControllerInterface<T> {
    private final Class<T> entityClass;
    private final SessionFactory hibernateUtil;

    public HibernateController(Class<T> entityClass) {
        this.hibernateUtil = HibernateUtil.getSession();
        this.entityClass = entityClass;
    }

    @Override
    public void add(Object o) {
        Transaction transaction = null;
        try (Session session = hibernateUtil.openSession()) {
            transaction = session.beginTransaction();
            session.save(o);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void remove(Integer id) {
        Transaction transaction = null;
        try (Session session = hibernateUtil.openSession()) {
            transaction = session.beginTransaction();
            T entity = session.get(entityClass, id);
            if (entity != null) {
                session.delete(entity);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public List<T> getAll() {
        try (Session session = hibernateUtil.openSession()) {
            return session.createQuery("FROM " + entityClass.getName(), entityClass).list();
        } catch (Exception e) {
            e.printStackTrace();
            return List.of();
        }
    }

    @Override
    public T getById(Integer id) {
        try (Session session = hibernateUtil.openSession()) {
            return session.get(entityClass, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
