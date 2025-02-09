package org.skypro.skyshop.searchEngine;

import org.skypro.skyshop.exception.BestResultNotFound;

import java.util.LinkedList;

public class SearchEngine {
    private final LinkedList<Searchable> searchables;

    public SearchEngine(int size) {
        this.searchables = new LinkedList<>();
    }

    // Метод добавления нового объекта Searchable в массив
    public void add(Searchable searchable) {
        if (searchable != null) {
            this.searchables.add(searchable);
        }
    }

    // Метод поиска по строке
    public LinkedList<Searchable> search(String query) {
        LinkedList<Searchable> results = new LinkedList<>();

        for (Searchable searchable : searchables) {
            if (searchable.getSearchTerm().contains(query)) {
                results.add(searchable);
            }
        }

        return results;
    }

    public Searchable findBestMatch(String query) throws BestResultNotFound {
        Searchable bestMatch = null;
        int maxCount = 0;

        for (Searchable searchable : searchables) {
            if (searchable != null) {
                int count = countOccurrences(searchable.getSearchTerm(), query);
                if (count > maxCount) {
                    maxCount = count;
                    bestMatch = searchable;
                }
            }

        }
        if (bestMatch == null) {
            throw new BestResultNotFound(query);
        }
        return bestMatch;
    }

    private int countOccurrences(String str, String substring) {
        int count = 0;
        int index = 0;

        while ((index = str.indexOf(substring, index)) != -1) {
            count++;
            index += substring.length();
        }

        return count;
    }
}
