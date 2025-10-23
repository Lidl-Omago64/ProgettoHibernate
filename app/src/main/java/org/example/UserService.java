package org.example;

import org.example.controller.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.example.model.User;

import java.util.List;

public class UserService {


    private static final SessionFactory sessionFactory =
            HibernateUtil.getSession();

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
