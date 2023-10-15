package ru.aston.artamonov_va.task1.task10;

import lombok.Getter;

import javax.annotation.PreDestroy;

@Getter
public class MusicPlayer {
    private final String model;

    public MusicPlayer(String model) {
        this.model = model;
    }

    public void play(Music music) {
        System.out.println(music.getMusic());
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Destroy method");
    }
}