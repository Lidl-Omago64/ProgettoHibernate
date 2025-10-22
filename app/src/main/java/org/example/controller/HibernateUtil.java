package org.example.controller;


import lombok.Getter;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    @Getter
    private static final SessionFactory session = connect();

    private HibernateUtil() {}

    private static SessionFactory connect() {
        try{
            return new Configuration().configure().buildSessionFactory();
        }catch (HibernateException e){
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return session;
    }

    public static void close() {
        getSession().close();
    }
}
