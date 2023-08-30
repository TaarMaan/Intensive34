package ru.aston.artamonov_va.task1.dto;


import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class User {
    private int age;
    private String sourName;
    private String name;
}