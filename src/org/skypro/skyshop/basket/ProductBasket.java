package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Iterator;
import java.util.LinkedList;

public class ProductBasket {
    private final LinkedList<Product> products;
    private int count;
    public static int specialProductCount = 0;

    public ProductBasket() {
        this.products = new LinkedList<>();

    }

    public int incrementSpecialCount() {
        for (Product basket : products) {
            if (basket != null && basket.isSpecial()) {
                specialProductCount++;
            }
        }
        return specialProductCount;
    }

    public void addProduct(Product product) {
        if (product != null) {
            this.products.add(product);
            count++;
        }
    }

    public int getTotalCost() {
        int total = 0;
        for (Product product : products) {
            if (product != null) {

                total += product.getCost();
            }
        }
        return total;
    }

    public void printBasket() {
        if (count == 0) {
            System.out.println("В корзине пусто");
            return;
        }
        for (Product product : products) {
            System.out.println(product);
        }
        System.out.println("Итого: " + getTotalCost() + "P");
        System.out.println("Количество специальных товаров  " + incrementSpecialCount());
    }


    public boolean containsProduct(String productName) {
        for (int i = 0; i < count; i++) {
            if (products.get(i).getName().equalsIgnoreCase(productName)) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        for (int i = 0; i < count; i++) {
            products.set(i, null);
        }
        count = 0;
    }
    public LinkedList<Product> removeProductsByName(String name) {
        LinkedList<Product> removedProducts = new LinkedList<>();
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {

            Product product = iterator.next();

            if (product.getName().equals(name)) {
                removedProducts.add(product);
                iterator.remove();
                System.out.println("Удаленные продукты: " + product);
            }
           else if (product.isSpecial()) {
                specialProductCount--;
            }
        }
        if (removedProducts.isEmpty()) {
            System.out.println("\n Список пуст\n");
        }

        return removedProducts;
    }
}
