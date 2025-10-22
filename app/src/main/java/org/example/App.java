package org.example;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.example.model.User;

public class App {

    public static void main(String[] args) {
        System.out.println("🚀 Avvio test Hibernate...");

        try (var sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory()) {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            User user = new User();
            user.setName("Mario Rossi");
            user.setEmail("mario.rossi@example.com");

            session.persist(user);
            transaction.commit();
            session.close();

            System.out.println("✅ Hibernate ha salvato l'utente con successo!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("❌ Errore durante il test di Hibernate");
        }
    }
}
