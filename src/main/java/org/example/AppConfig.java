package org.example;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration  // indique à Spring que c'est une classe de configuration
@ComponentScan(basePackages = "org.example") // Spring va scanner ce package et ses sous-packages
public class AppConfig {
    // Pas besoin d'autre code ici
}