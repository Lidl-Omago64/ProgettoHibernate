package org.example;

import org.example.controller.HibernateController;
import org.example.controller.HibernateControllerInterface;
import org.example.model.User;
import org.example.model.statistics.TransactionStatistics;
import org.example.model.transaction.DeadlineTransaction;
import org.example.model.transaction.NormalTransaction;
import org.example.model.transaction.Transaction;

import java.time.LocalDate;
import java.util.Date;
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
        // ===============================================================
        // 🔹 SEZIONE DI TEST PER TransactionStatistics
        // ===============================================================

        System.out.println("📊 Avvio test statistiche sulle transazioni...");

        NormalTransaction t1 = new NormalTransaction();
        t1.setAmount(100.0);
        t1.setDescription("Spesa alimentare");
        t1.setDate(LocalDate.of(2025, 1, 25));

        NormalTransaction t2 = new NormalTransaction();
        t2.setAmount(50.0);
        t2.setDescription("Rifornimento auto");
        t2.setDate(LocalDate.of(2025, 2, 1));



        NormalTransaction t3 = new NormalTransaction();
        t3.setAmount(200.0);
        t3.setDescription("Elettronica");
        t3.setDate(LocalDate.of(2025, 2, 5));

        DeadlineTransaction t4 = new DeadlineTransaction();
        t4.setAmount(150.0);
        t4.setDescription("Sulpa");
        t4.setDate(LocalDate.of(2025, 2, 8));

        List<Transaction> transactions = List.of(t1, t2, t3, t4);

        LocalDate start = LocalDate.of(2025, 1, 1);  // 1 gennaio 2025
        LocalDate end = LocalDate.of(2025, 12, 28);   // 28 febbraio 2025

        TransactionStatistics stats = new TransactionStatistics(start, end, transactions);

        System.out.println("\n📅 Periodo analizzato: " + start + " → " + end);
        System.out.println("Transazioni nel periodo:");
        stats.getTransactionsInPeriod().forEach(t ->
                System.out.println(" - " + t.getDescription() + " | Importo: " + t.getAmount())
        );

        System.out.println("\n💰 Totale importi: " + stats.getTotalAmount());
        System.out.println("📈 Media importi: " + stats.getAverageAmount());
        System.out.println("✅ Fine test statistiche");
    }
}
