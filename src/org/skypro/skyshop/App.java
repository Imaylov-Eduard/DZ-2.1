package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;
import org.skypro.skyshop.search.BestResultNotFound;

import java.util.List;

public class App {
    public static void main(String[] args) throws BestResultNotFound {

        Product laptop = new SimpleProduct("Ноутбук", 50000);
        Product smartphone = new SimpleProduct("Смартфон", 30000);
        Product headphones = new DiscountedProduct("Наушники", 5000, 20);
        Product monitor = new FixPriceProduct("Монитор");
        Product keyboard = new FixPriceProduct("Клавиатура");


        Article article1 = new Article("Обзор ноутбука", "Подробный обзор нового ноутбука...");
        Article article2 = new Article("Как выбрать смартфон", "Советы по выбору лучшего смартфона...");


        SearchEngine searchEngine = new SearchEngine();


        searchEngine.add(laptop);
        searchEngine.add(smartphone);
        searchEngine.add(headphones);
        searchEngine.add(monitor);
        searchEngine.add(keyboard);
        searchEngine.add(article1);
        searchEngine.add(article2);


        String query = "ноутбук";
        List<Searchable> searchResults = searchEngine.search(query);
        System.out.println("Результаты поиска по запросу \"" + query + "\":");
        for (Searchable result : searchResults) {
            System.out.println(result.getName());
        }


        ProductBasket basket = new ProductBasket();
        basket.addProduct(laptop);
        basket.addProduct(smartphone);
        basket.addProduct(headphones);
        basket.addProduct(monitor);
        basket.addProduct(keyboard);

        basket.printBasket();

        System.out.println("Общая стоимость корзины: " + basket.getTotalCost());


        String productToRemove = "Смартфон";
        List<Product> removedProducts = basket.removeProductsByName(productToRemove);
        System.out.println("\nУдаленные продукты:");
        for (Product product : removedProducts) {
            System.out.println(product);
        }

        System.out.println("\nСодержимое корзины после удаления:");
        basket.printBasket();


        String nonExistentProduct = "Планшет";
        List<Product> emptyList = basket.removeProductsByName(nonExistentProduct);
        if (emptyList.isEmpty()) {
            System.out.println("\nСписок пуст: продукт \"" + nonExistentProduct + "\" не найден.");
        }


        Searchable bestMatch = searchEngine.findBestMatch("ноутбук");
        System.out.println("\nНайден лучший результат: " + bestMatch.getName());
    }
}