/**
 * This file is that "Java Do #06" changed.
 */

package com.example;

import java.util.List;

public class ProductResource {

    public static Product getProduct() {
        Product product = new Product();
        product.setId(200);
        product.setName("Java Do");
        product.setPrice(2800);
        return product;
    }

    public static List<Product> getProducts() {
        IDAOMock dao = DAOMock.getInstance();
        return dao.select();
    }

    public static Product getProduct(int id) {
        IDAOMock dao = DAOMock.getInstance();
        try {
            Product product = dao.select(id);
            return product;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean postProducts(Product product) {
        IDAOMock dao = DAOMock.getInstance();
        try {
            dao.insert(product);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean putProducts(int id, Product product) {
        IDAOMock dao = DAOMock.getInstance();
        try {
            dao.update(id, product);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean deleteProduct(int id) {
        IDAOMock dao = DAOMock.getInstance();
        try {
            dao.delete(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
