package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.exception.BestResultNotFound;
import org.skypro.skyshop.product.*;
import org.skypro.skyshop.searchEngine.SearchEngine;
import org.skypro.skyshop.searchEngine.Searchable;


public class App {


    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();
        Product a1 = new SimpleProduct("Телефон", 1000);
        Product a2 = new DiscountedProduct("Кроссовки", 900, 100);
        Product a3 = new FixPriceProduct("Наушники");

        Product a4 = new SimpleProduct("Пульт", 700);
        Product a5 = new SimpleProduct("Мышка", 600);
        Product a6 = new SimpleProduct("Ёлка", 400);


        basket.addProduct(a1);
        basket.addProduct(a2);
        basket.addProduct(a3);
        basket.addProduct(a4);
        basket.addProduct(a5);

        basket.addProduct(a6);

        basket.printBasket();

        System.out.println("В корзине есть мышька?" + basket.containsProduct("мышка"));
        System.out.println("В корзине есть ёлка?" + basket.containsProduct("ёлка"));

        basket.clearBasket();
        basket.printBasket();
        System.out.println("Общая стоимость корзины: " + basket.getTotalCost());
        System.out.println("В корзине есть мышька?" + basket.containsProduct("мышка"));

        //Реализация поисковой системы
        SearchEngine searchEngine = new SearchEngine(10);
        searchEngine.add(new Article("Introduction to Java", "Java is a versatile language..."));
        searchEngine.add(new Article("Learning Python", "Python is great for beginners."));
        searchEngine.add(new Article("Advanced Java Concepts", "Exploring multithreading in Java..."));
        searchEngine.add(new SimpleProduct("Laptop", 50000));
        searchEngine.add(new SimpleProduct("Java Book", 1500));
        searchEngine.add(new FixPriceProduct("Notebook"));
        searchEngine.add(new DiscountedProduct("Headphones", 3000, 20));


        String[] queries = {"Java", "Python", "Laptop", "Book"};

        for (String query : queries) {
            System.out.println("\nПоиск по запросу: " + query);
            Searchable[] results = searchEngine.search(query);

            for (Searchable result : results) {
                if (result != null) {
                    System.out.println("Результаты поиска: " + result.getStringRepresentation());
                }
            }
        }
        System.out.println("\n Домашнее задание Исключения в Java ");

        try {
            Product product1 = new SimpleProduct(" ", 1000);
            System.out.println(product1);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        try {
            Product product2 = new DiscountedProduct("Кроссовки", 900, 101);
            System.out.println(product2);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        try {
            Product product4 = new SimpleProduct("Пульт", -1);
            System.out.println(product4);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }


        try {
            Searchable bestMatch = searchEngine.findBestMatch("Java");
            System.out.println("Максимальное повторение слова Java : " + bestMatch);
        } catch (BestResultNotFound e) {
            System.out.println(e);
        }
        try {
            Searchable bestMatch = searchEngine.findBestMatch("Kotlin");
            System.out.println("Максимальное повторение слова Java в: " + bestMatch);
        } catch (BestResultNotFound e) {
            System.out.println(e);
        }
    }
}
