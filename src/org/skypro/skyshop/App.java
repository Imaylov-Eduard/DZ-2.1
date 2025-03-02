package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;
import org.skypro.skyshop.search.BestResultNotFound;

public class App {
    public static void main(String[] args) {

        try {
            Product invalidProduct = new SimpleProduct("", 100);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            Product invalidPrice = new SimpleProduct("Телефон", -1);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            Product invalidDiscount = new DiscountedProduct("Наушники", 100, -10);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }


        SearchEngine searchEngine = new SearchEngine();


        searchEngine.add(new SimpleProduct("Ноутбук", 50000));
        searchEngine.add(new Article("Обзор ноутбука", "Подробный обзор нового ноутбука..."));


        try {
            Searchable bestMatch = searchEngine.findBestMatch("ноутбук");
            System.out.println("Найден лучший результат: " + bestMatch.getName());
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка: " + e.getMessage());
        }


        try {
            Searchable noMatch = searchEngine.findBestMatch("планшет");
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}