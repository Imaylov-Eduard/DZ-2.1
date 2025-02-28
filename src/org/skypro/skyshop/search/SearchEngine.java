package org.skypro.skyshop.search;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {
    private final List<Searchable> searchables; // Заменяем массив на список

    public SearchEngine() {
        searchables = new ArrayList<>(); // Инициализируем список
    }

    public void add(Searchable item) {
        searchables.add(item); // Добавляем элемент без ограничений
    }

    public List<Searchable> search(String query) {
        List<Searchable> results = new ArrayList<>();
        for (Searchable item : searchables) {
            if (item.getSearchTerm().toLowerCase().contains(query.toLowerCase())) {
                results.add(item); // Добавляем все подходящие результаты
            }
        }
        return results;
    }

    public Searchable findBestMatch(String search) throws BestResultNotFound {
        Searchable bestMatch = null;
        int maxCount = -1;

        for (Searchable item : searchables) {
            String searchTerm = item.getSearchTerm();
            int currentCount = countOccurrences(searchTerm, search);

            if (currentCount > maxCount) {
                maxCount = currentCount;
                bestMatch = item;
            }
        }

        if (bestMatch == null) {
            throw new BestResultNotFound("Не найдено подходящего результата для запроса: " + search);
        }

        return bestMatch;
    }

    private int countOccurrences(String text, String substring) {
        int count = 0;
        int index = 0;
        while ((index = text.indexOf(substring, index)) != -1) {
            count++;
            index += substring.length();
        }
        return count;
    }
}