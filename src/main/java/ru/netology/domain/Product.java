package ru.netology.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Product {
    private int id;
    private String name;
    private int price;

    public boolean matches (String search) {
        return search.equalsIgnoreCase(name);
    }
}
