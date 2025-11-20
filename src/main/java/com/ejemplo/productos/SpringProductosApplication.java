package com.ejemplo.productos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Punto de entrada de la aplicación Spring Boot
@SpringBootApplication
public class SpringProductosApplication {

    public static void main(String[] args) {
        // Inicia el contexto de Spring y arranca el servidor embebido (por defecto Tomcat)
        SpringApplication.run(SpringProductosApplication.class, args);
    }
}
