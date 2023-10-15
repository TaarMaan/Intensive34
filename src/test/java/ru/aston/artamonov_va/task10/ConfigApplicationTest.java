package ru.aston.artamonov_va.task10;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.aston.artamonov_va.task1.task10.Music;
import ru.aston.artamonov_va.task1.task10.MusicPlayer;
import ru.aston.artamonov_va.task1.task10.java.Config;

public class ConfigApplicationTest {
    @Test
    void test() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);

        MusicPlayer musicPlayer = applicationContext.getBean(MusicPlayer.class);
        System.out.println(musicPlayer.getModel());
        musicPlayer.play(applicationContext.getBean(Music.class));
        musicPlayer.play(applicationContext.getBean(Music.class));
        musicPlayer.play(applicationContext.getBean(Music.class));
        musicPlayer.play(applicationContext.getBean(Music.class));
        musicPlayer.play(applicationContext.getBean(Music.class));
        musicPlayer.play(applicationContext.getBean(Music.class));
        musicPlayer.play(applicationContext.getBean(Music.class));
    }
}