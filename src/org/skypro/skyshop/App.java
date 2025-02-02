package org.skypro.skyshop;

import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.basket.ProductBasket;

public class App {
    public static void main(String[] args) {

        Product product1 = new Product("Ноутбук", 50000);
        Product product2 = new Product("Смартфон", 30000);
        Product product3 = new Product("Наушники", 5000);
        Product product4 = new Product("Монитор", 15000);
        Product product5 = new Product("Клавиатура", 3000);
        Product product6 = new Product("Мышь", 2000); // для проверки переполнения корзины


        ProductBasket basket = new ProductBasket();


        basket.addProduct(product1);
        basket.addProduct(product2);
        basket.addProduct(product3);
        basket.addProduct(product4);
        basket.addProduct(product5);


        basket.addProduct(product6);


        basket.printBasket();


        System.out.println("Общая стоимость корзины: " + basket.getTotalCost());


        String searchName1 = "Смартфон";
        System.out.println("В корзине " + (basket.containsProduct(searchName1) ? "есть" : "нет") + " продукт \"" + searchName1 + "\"");


        String searchName2 = "Планшет";
        System.out.println("В корзине " + (basket.containsProduct(searchName2) ? "есть" : "нет") + " продукт \"" + searchName2 + "\"");


        basket.clearBasket();


        basket.printBasket();


        System.out.println("Общая стоимость корзины: " + basket.getTotalCost());


        System.out.println("В корзине " + (basket.containsProduct(searchName1) ? "есть" : "нет") + " продукт \"" + searchName1 + "\"");
    }
}