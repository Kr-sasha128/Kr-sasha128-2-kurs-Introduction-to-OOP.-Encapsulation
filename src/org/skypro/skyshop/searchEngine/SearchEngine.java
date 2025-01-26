package org.skypro.skyshop.searchEngine;

public class SearchEngine {
    private final Searchable[] searchables;
    private int currentIndex;

    public SearchEngine(int size) {
        this.searchables = new Searchable[size];
        this.currentIndex = 0;
    }

    // Метод добавления нового объекта Searchable в массив
    public void add(Searchable searchable) {
        if (currentIndex < searchables.length) {
            searchables[currentIndex] = searchable;
            currentIndex++;
        } else {
            System.out.println("Невозможно добавить элемент: массив заполнен.");
        }
    }

    // Метод поиска по строке
    public Searchable[] search(String query) {
        Searchable[] results = new Searchable[5]; // Массив для хранения первых 5 результатов
        int resultIndex = 0;

        for (Searchable searchable : searchables) {
            if (searchable != null && searchable.getSearchTerm().contains(query) || searchable != null && searchable.getSearchTerm().contains(query) ) {
                results[resultIndex++] = searchable;
                if (resultIndex == 5) {
                    break; // Если нашли 5 элементов, выходим из цикла
                }
            }
        }

        return results;
    }
}
