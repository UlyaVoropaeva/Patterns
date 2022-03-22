package ru.gb.configuration;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration
@Import(ApplicationClientsProperties.class)
public class ApplicationConfig {
}
