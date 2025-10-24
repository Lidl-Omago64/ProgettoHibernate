package org.example;

import org.example.controller.HibernateController;
import org.example.controller.HibernateControllerInterface;
import org.example.model.User;
import java.util.List;

public class App {

    public static void main(String[] args) {
        System.out.println("🚀 Avvio test Hibernate...");

        HibernateControllerInterface<User> userService = new HibernateController<>(User.class);

        User user = new User();
        user.setName("Avvio");
        user.setEmail("avvio@gmail.com");
        // 🔹 Aggiunge un nuovo utente
        userService.add(user);

        // 🔹 Legge e mostra tutti gli utenti dal DB
        List<User> utenti = userService.getAll();

        System.out.println("📋 Utenti trovati nel database:");
        for (User u : utenti) {
            System.out.println(" - ID: " + u.getId() + " | Nome: " + u.getName() + " | Email: " + u.getEmail());
        }

        System.out.println("✅ Fine test Hibernate");
    }
}
