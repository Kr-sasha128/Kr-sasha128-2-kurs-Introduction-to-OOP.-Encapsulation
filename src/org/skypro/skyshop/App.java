package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {
        ProductBasket basket = new ProductBasket();
        Product a1 = new SimpleProduct("Телефон", 1000);
        Product a2 = new DiscountedProduct("Кроссовки", 900, 50);
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

    }
}

