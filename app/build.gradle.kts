plugins {
    // Plugin per applicazione Java
    application

    // ➕ Plugin Spring Boot
    id("org.springframework.boot") version "3.3.5"

    // ➕ Gestione automatica delle versioni delle dipendenze
    id("io.spring.dependency-management") version "1.1.6"
}

repositories {
    mavenCentral()
}

dependencies {
    // 🌱 Spring Boot Starter (core)
    implementation("org.springframework.boot:spring-boot-starter")

    // 🌱 Spring Boot Starter per JPA (integrazione con Hibernate)
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    // 🌱 Spring Boot Starter per applicazioni web (se vuoi un'API REST)
    implementation("org.springframework.boot:spring-boot-starter-web")

    // Database drivers
    implementation("org.hibernate.orm:hibernate-core:6.4.1.Final")
    implementation("org.hibernate.orm:hibernate-community-dialects:6.4.1.Final")
    implementation("org.xerial:sqlite-jdbc:3.46.0.0")
    implementation("jakarta.persistence:jakarta.persistence-api:3.1.0")
    implementation("com.h2database:h2:2.2.224")

    // Lombok
    compileOnly("org.projectlombok:lombok:1.18.42")
    annotationProcessor("org.projectlombok:lombok:1.18.42")

    testCompileOnly("org.projectlombok:lombok:1.18.42")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.42")

    // Test
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

// Definisci la main class (Spring Boot ignorerà "application" se usi @SpringBootApplication)
application {
    mainClass = "org.example.App"
}
