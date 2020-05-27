package com.example;

import lombok.Data;

@Data
public class Product {
    private int id;
    private String name;
    private int price;

    public Product() {
        this.id = 0;
        this.name = "";
        this.price = 0;
    }

}
