package ru.aston.artamonov_va.task1.task7.entity;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class UserOrder extends User{
    @Type(type = "jsonb")
    @Column(name = "meta")
    private String meta;
}