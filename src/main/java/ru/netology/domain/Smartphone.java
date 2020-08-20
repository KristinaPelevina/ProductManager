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

    @Override
    public boolean matches (String search) {
        if (super.matches(search)) {
            return true;
        }
        if (search.equalsIgnoreCase(country)){
            return true;
        }
        return false;
    }
}