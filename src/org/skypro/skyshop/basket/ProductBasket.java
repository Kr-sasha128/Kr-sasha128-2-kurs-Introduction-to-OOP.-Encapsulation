package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private final Product[] products;
    public int count;
    public static int specialProductCount = 0;

    public ProductBasket() {
        this.products = new Product[5];

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
        for (int i = 0; i < this.products.length; i++) {
            if (this.products[i] == null) {
                this.products[i] = product;
                count++;
                return;
            }
        }
        System.out.println("Невозможно добавить продукт");
    }

    public int getTotalCost() {
        int total = 0;
        for (int i = 0; i < count; i++) {
            total += products[i].getCost();
        }
        return total;
    }

    public void printBasket() {
        if (count == 0) {
            System.out.println("В корзине пусто");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println(products[i]);
        }
        System.out.println("Итого: " + getTotalCost() + "P");
        System.out.println("Количество специальных товаров  " + incrementSpecialCount());
    }

    public boolean containsProduct(String productName) {
        for (int i = 0; i < count; i++) {
            if (products[i].getName().equalsIgnoreCase(productName)) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        for (int i = 0; i < count; i++) {
            products[i] = null;
        }
        count = 0;
    }
}
