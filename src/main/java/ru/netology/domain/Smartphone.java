package ru.netology.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode (callSuper = true)

public class Smartphone extends Product {
    private String country;

    public Smartphone (int id, String name, int price, String country) {
        super(id, name, price);
        this.country = country;
    }
}