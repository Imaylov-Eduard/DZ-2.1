package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;
import org.skypro.skyshop.search.BestResultNotFound;

import java.util.Arrays;

public class App {
    public static void main(String[] args) throws BestResultNotFound {
        // Создание товаров
        Product laptop = new SimpleProduct("Ноутбук", 50000);
        Product smartphone = new SimpleProduct("Смартфон", 30000);
        Product headphones = new DiscountedProduct("Наушники", 5000, 20);
        Product monitor = new FixPriceProduct("Монитор");
        Product keyboard = new FixPriceProduct("Клавиатура");

        // Создание статей
        Article article1 = new Article("Обзор ноутбука", "Подробный обзор нового ноутбука...");
        Article article2 = new Article("Как выбрать смартфон", "Советы по выбору лучшего смартфона...");

        // Создание SearchEngine
        SearchEngine searchEngine = new SearchEngine(10); // Укажите размер массива

        // Добавление товаров и статей в SearchEngine
        searchEngine.add(laptop);
        searchEngine.add(smartphone);
        searchEngine.add(headphones);
        searchEngine.add(monitor);
        searchEngine.add(keyboard);
        searchEngine.add(article1);
        searchEngine.add(article2);

        // Тестирование поиска
        String query = "ноутбук";
        Searchable[] searchResults = searchEngine.search(query);
        System.out.println("Результаты поиска по запросу \"" + query + "\": " + Arrays.toString(searchResults));

        // Пример работы с корзиной
        ProductBasket basket = new ProductBasket();
        basket.addProduct(laptop);
        basket.addProduct(smartphone);
        basket.addProduct(headphones);
        basket.addProduct(monitor);
        basket.addProduct(keyboard);

        basket.printBasket();

        System.out.println("Общая стоимость корзины: " + basket.getTotalCost());

        String searchName1 = "Смартфон";
        System.out.println("В корзине " + (basket.containsProduct(searchName1) ? "есть" : "нет") + " продукт \"" + searchName1 + "\"");

        String searchName2 = "Планшет";
        System.out.println("В корзине " + (basket.containsProduct(searchName2) ? "есть" : "нет") + " продукт \"" + searchName2 + "\"");

        basket.clearBasket();
        basket.printBasket();

        // Демонстрация нового метода поиска
        Searchable bestMatch = searchEngine.findBestMatch("ноутбук");
        System.out.println("Найден лучший результат: " + bestMatch.getName());


        Searchable bestMatch1 = searchEngine.findBestMatch("планшет"); // Несуществующий запрос
        System.out.println("Найден лучший результат: " + bestMatch.getName());
    }
}