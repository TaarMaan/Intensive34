package ru.aston.artamonov_va.task1.task10;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Random;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class RockMusic implements Music {
    private String music;

    @PostConstruct
    public void init() {
        System.out.println("init method");
        music = List.of("Nickelback - Lullaby", "Rise Against - Hero of war", "Girugamesh - Limit break")
                .get(new Random().nextInt(3));
    }
    @Override
    public String getMusic() {
        return music;
    }
}