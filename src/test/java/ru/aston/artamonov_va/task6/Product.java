package ru.aston.artamonov_va.task6;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Product {
    private String name;
    private String category;
    private double price;
}
