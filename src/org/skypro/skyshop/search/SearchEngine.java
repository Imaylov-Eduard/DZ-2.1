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
}