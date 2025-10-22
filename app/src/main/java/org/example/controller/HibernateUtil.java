package org.example.controller;


import org.hibernate.SessionFactory;

public class HibernateUtil {
    private static SessionFactory session = connect();

    private HibernateUtil() {}

    public SessionFactory getSession() {
        return session;
    }

    private static SessionFactory connect() {
        try{


        }
    }
}
