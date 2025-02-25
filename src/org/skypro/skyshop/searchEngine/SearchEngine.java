package org.skypro.skyshop.searchEngine;

import org.skypro.skyshop.exception.BestResultNotFound;

import java.util.*;

public class SearchEngine implements Comparable<SearchEngine> {
    private final HashSet<Searchable> searchables;

    public SearchEngine(int size) {
        this.searchables = new HashSet<>();
    }

    // Метод добавления нового объекта Searchable в массив
    public void add(Searchable searchable) {
        if (searchable != null) {
            this.searchables.add(searchable);
        }
    }

    // Метод поиска по строке
    public Set<Searchable> search(String query) {
        Set<Searchable> results = new TreeSet<>(new SearchableComparator());

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

    @Override
    public int compareTo(SearchEngine o) {
        return Integer.compare(this.searchables.size(), o.searchables.size());
    }

    private static class SearchableComparator implements Comparator<Searchable> {
        @Override
        public int compare(Searchable s1, Searchable s2) {
            int lengthComparison = Integer.compare(s2.getName().length(), s1.getName().length());
            return (lengthComparison != 0) ? lengthComparison : s1.getName().compareTo(s2.getName());
        }
    }
}