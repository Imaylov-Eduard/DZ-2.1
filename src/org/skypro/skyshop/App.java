package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();



        basket.addProduct(new SimpleProduct("Ноутбук", 50000));
        basket.addProduct(new SimpleProduct("Смартфон", 30000));
        basket.addProduct(new DiscountedProduct("Наушники", 5000, 20));
        basket.addProduct(new FixPriceProduct("Монитор"));
        basket.addProduct(new FixPriceProduct("Клавиатура"));

        basket.printBasket();

        System.out.println("Общая стоимость корзины: " + basket.getTotalCost());

        String searchName1 = "Смартфон";
        System.out.println("В корзине " + (basket.containsProduct(searchName1) ? "есть" : "нет") + " продукт \"" + searchName1 + "\"");

        String searchName2 = "Планшет";
        System.out.println("В корзине " + (basket.containsProduct(searchName2) ? "есть" : "нет") + " продукт \"" + searchName2 + "\"");

        basket.clearBasket();
        basket.printBasket();
    }
}