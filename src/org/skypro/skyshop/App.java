package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.exception.BestResultNotFound;
import org.skypro.skyshop.product.*;
import org.skypro.skyshop.searchEngine.SearchEngine;
import org.skypro.skyshop.searchEngine.Searchable;

import java.util.LinkedList;
import java.util.Map;


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

        System.out.println("В корзине есть мышька?" + basket.containsProduct("Мышка"));
        System.out.println("В корзине есть ёлка?" + basket.containsProduct("Ёлка"));

        basket.clearBasket();
        basket.printBasket();
        System.out.println("Общая стоимость корзины: " + basket.getTotalCost());
        System.out.println("В корзине есть мышька?" + basket.containsProduct("мышка"));

        System.out.println("\n Реализация поисковой системы");

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
            Map<String, Searchable> results = searchEngine.search(query);
            if (results.isEmpty()) {
                System.out.println("Ничего не найдено");
            }
            for (Searchable result : results.values()) {
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

        System.out.println("\nДомашнее задание Листы ");

        ProductBasket basket1 = new ProductBasket();
        Product p1 = new SimpleProduct("Ноутбук", 2500);
        Product p2 = new DiscountedProduct("Куртка", 1500, 40);
        Product p3 = new FixPriceProduct("Часы");
        Product p4 = new SimpleProduct("Клавиатура", 850);
        Product p5 = new SimpleProduct("Флешка", 450);
        Product p6 = new SimpleProduct("Рюкзак", 1200);

        basket1.addProduct(p1);
        basket1.addProduct(p2);
        basket1.addProduct(p3);
        basket1.addProduct(p4);
        basket1.addProduct(p5);
        basket1.addProduct(p6);

        basket1.removeProductsByName("Часы");
        basket1.removeProductsByName("Клавиатура");

        basket1.printBasket();

        basket1.removeProductsByName("Телевизор");


        basket1.printBasket();
    }
}