package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {

    private final Product[] products;

    private int count;


    public ProductBasket() {
        products = new Product[5];
        count = 0;
    }
    public void addProduct(Product product) {
        if (count >= products.length) {
            System.out.println("Невозможно добавить продукт");
            return;
        }
        products[count] = product;
        count++;
    }
    public int getTotalCost() {
        int total = 0;
        for (int i = 0; i < count; i++) {
            total += products[i].getPrice();
        }
        return total;
    }
    public void printBasket() {
        if (count == 0) {
            System.out.println("в корзине пусто");
            return;
        }
        for (int i = 0; i < count; i++) {
            Product product = products[i];
            System.out.println(product.getName() + ": " + product.getPrice());
        }
        System.out.println("Итого: " + getTotalCost());
    }
    public boolean containsProduct(String name) {
        for (int i = 0; i < count; i++) {
            if (products[i].getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        for (int i = 0; i < count; i++) {
            products[i] = null;
        }
        count = 0;
    }
}
