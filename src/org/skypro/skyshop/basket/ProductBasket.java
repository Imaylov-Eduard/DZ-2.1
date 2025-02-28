package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private final Map<String, List<Product>> products; // Заменяем список на Map

    public ProductBasket() {
        products = new HashMap<>(); // Инициализируем Map
    }

    public void addProduct(Product product) {
        // Получаем список продуктов по имени
        List<Product> productList = products.getOrDefault(product.getName(), new ArrayList<>());
        productList.add(product); // Добавляем продукт в список
        products.put(product.getName(), productList); // Обновляем Map
    }

    public int getTotalCost() {
        int total = 0;
        for (List<Product> productList : products.values()) {
            for (Product product : productList) {
                total += product.getPrice();
            }
        }
        return total;
    }

    public void printBasket() {
        if (products.isEmpty()) {
            System.out.println("В корзине пусто");
            return;
        }

        int specialCount = 0;
        for (List<Product> productList : products.values()) {
            for (Product product : productList) {
                System.out.println(product.toString());
                if (product.isSpecial()) {
                    specialCount++;
                }
            }
        }

        System.out.println("Итого: " + getTotalCost());
        System.out.println("Специальных товаров: " + specialCount);
    }

    public boolean containsProduct(String name) {
        return products.containsKey(name); // Проверяем наличие продукта по имени
    }

    public void clearBasket() {
        products.clear(); // Очищаем Map
    }

    public List<Product> removeProductsByName(String name) {
        List<Product> removedProducts = products.remove(name); // Удаляем продукты по имени
        return removedProducts != null ? removedProducts : new ArrayList<>(); // Возвращаем удаленные продукты
    }
}