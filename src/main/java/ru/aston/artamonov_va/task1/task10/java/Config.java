package ru.aston.artamonov_va.task1.task10.java;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import ru.aston.artamonov_va.task1.task10.MusicPlayer;

@Configuration
@ComponentScan(basePackages = "ru.aston.artamonov_va.task1.task10")
@PropertySource("classpath:/application.properties")
public class Config {
    @Value("${config}")
    String model;
    @Bean
    public MusicPlayer musicPlayer() {
        return new MusicPlayer(model);
    }
}