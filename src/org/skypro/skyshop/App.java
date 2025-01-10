package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();
        Product a1 = new Product("Телефон", 1000);
        Product a2 = new Product("Кроссовки", 900);
        Product a3 = new Product("Наушники", 800);
        Product a4 = new Product("Пульт", 700);
        Product a5 = new Product("Мышка", 600);
        Product a6 = new Product("Ёлка", 400);


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
    }
}

