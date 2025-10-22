package org.example;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.example.model.User;

import java.util.List;

public class UserService {

    private static final org.hibernate.SessionFactory sessionFactory =
            new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

    // ✅ Salva un nuovo utente nel database
    public void saveUser(String name, String email) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();

            User user = new User();
            user.setName(name);
            user.setEmail(email);

            session.persist(user);
            transaction.commit();

            System.out.println("✅ Utente salvato: " + user.getName());
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    // ✅ Recupera tutti gli utenti dal database
    @SuppressWarnings("unchecked")
    public List<User> getAllUsers() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from User").list();
        } catch (Exception e) {
            e.printStackTrace();
            return List.of();
        }
    }
}
