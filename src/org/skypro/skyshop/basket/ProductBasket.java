package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private final Map<String, List<Product>> products;


    public ProductBasket() {
        this.products = new HashMap<>();

    }

    public int incrementSpecialCount() {
        return products.values().stream().flatMap(Collection::stream)
                .filter(Product::isSpecial).
                mapToInt(specialProductCount -> 1).sum();

    }

    public void addProduct(Product product) {
        if (product != null) {
            products.computeIfAbsent(product.getName(), k -> new ArrayList<>()).add(product);
        }
    }

    public int getTotalCost() {
        return products.values().stream().flatMap(Collection::stream)
                .mapToInt(Product::getCost).sum();
    }

    public void printBasket() {
        if (products.isEmpty()) {
            System.out.println("В корзине пусто");
            return;
        }
        products.values().stream()
                .flatMap(Collection::stream)
                .forEach(System.out::println);

        System.out.println("Итого: " + getTotalCost() + "P");
        System.out.println("Количество специальных товаров  " + incrementSpecialCount());
    }


    public boolean containsProduct(String productName) {
        return products.containsKey(productName);
    }

    public void clearBasket() {
        products.clear();
    }

    public List<Product> removeProductsByName(String name) {
        List<Product> removedProducts = products.remove(name);
        if (removedProducts == null) {
            System.out.println("\n Список пуст\n");
            return Collections.emptyList();
        }
        products.remove(name);
        System.out.println("Удаленные продукты: " + removedProducts);
        return removedProducts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductBasket basket)) return false;
        return Objects.equals(products, basket.products);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(products);
    }
}