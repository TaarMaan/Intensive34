package ru.aston.artamonov_va.task1.task5.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Birthday {
    private LocalDate localDate;
}