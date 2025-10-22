package org.example;

import org.example.model.User;
import java.util.List;

public class App {

    public static void main(String[] args) {
        System.out.println("🚀 Avvio test Hibernate...");

        UserService userService = new UserService();

        // 🔹 Aggiunge un nuovo utente
        userService.saveUser("Mario Rossi", "mario.rossi@example.com");

        // 🔹 Legge e mostra tutti gli utenti dal DB
        List<User> utenti = userService.getAllUsers();

        System.out.println("📋 Utenti trovati nel database:");
        for (User u : utenti) {
            System.out.println(" - ID: " + u.getId() + " | Nome: " + u.getName() + " | Email: " + u.getEmail());
        }

        System.out.println("✅ Fine test Hibernate");
    }
}
