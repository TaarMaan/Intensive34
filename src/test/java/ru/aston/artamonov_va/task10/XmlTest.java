package ru.aston.artamonov_va.task10;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.aston.artamonov_va.task1.task10.MusicPlayer;
import ru.aston.artamonov_va.task1.task10.RockMusic;

public class XmlTest {
    @Test
    void testContext() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("config.xml");
        MusicPlayer musicPlayer = applicationContext.getBean(MusicPlayer.class);
        System.out.println(musicPlayer.getModel());
        musicPlayer.play(applicationContext.getBean(RockMusic.class));
        musicPlayer.play(applicationContext.getBean(RockMusic.class));
        musicPlayer.play(applicationContext.getBean(RockMusic.class));
        musicPlayer.play(applicationContext.getBean(RockMusic.class));
        musicPlayer.play(applicationContext.getBean(RockMusic.class));
        musicPlayer.play(applicationContext.getBean(RockMusic.class));
        musicPlayer.play(applicationContext.getBean(RockMusic.class));
        musicPlayer.play(applicationContext.getBean(RockMusic.class));
        applicationContext.close();
    }
}