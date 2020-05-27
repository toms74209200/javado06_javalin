package com.example;

import java.util.List;

public interface IDAOMock {
    List<Product> select();

    Product select(int id);

    void insert(Product product);

    void update(int id, Product product);

    void delete(int id);
}
