package org.skypro.skyshop.search;

import java.util.Arrays;

public class SearchEngine {
    private final Searchable[] searchables;
    private int count;

    public SearchEngine(int size) {
        searchables = new Searchable[size];
        count = 0;
    }

    public void add(Searchable item) {
        if (count < searchables.length) {
            searchables[count] = item;
            count++;
        }
    }

    public Searchable[] search(String query) {
        Searchable[] results = new Searchable[5];
        int resultCount = 0;

        for (int i = 0; i < count; i++) {
            if (searchables[i].getSearchTerm().toLowerCase().contains(query.toLowerCase())) {
                results[resultCount] = searchables[i];
                resultCount++;
                if (resultCount == 5) {
                    break;
                }
            }
        }
        return results;
    }

    public Searchable findBestMatch(String search) throws org.skypro.skyshop.search.BestResultNotFound {
        Searchable bestMatch = null;
        int maxCount = -1;

        for (int i = 0; i < count; i++) {
            String searchTerm = searchables[i].getSearchTerm();
            int currentCount = countOccurrences(searchTerm, search);

            if (currentCount > maxCount) {
                maxCount = currentCount;
                bestMatch = searchables[i];
            }
        }

        if (bestMatch == null) {
            throw new org.skypro.skyshop.search.BestResultNotFound("Не найдено подходящего результата для запроса: " + search);
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

