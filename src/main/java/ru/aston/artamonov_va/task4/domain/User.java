package ru.aston.artamonov_va.task4.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private String surname;
    private String phoneNumber;
    private String mail;
    private int orderId;

    //Для создания экземпляра без id
    public User(int id, String name, String surname, String phoneNumber, String mail) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.mail = mail;
    }
}