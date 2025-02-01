package org.skypro.skyshop.product;

import org.skypro.skyshop.searchEngine.Searchable;

public abstract class Product implements Searchable {
    private String name;

    public String getName() {
        return name;
    }

    public abstract int getCost();

    public boolean isSpecial() {
        return false;
    }


    public Product(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(" Поле name не заполнено");
        }
        this.name = name;

    }

    @Override
    public String getSearchTerm() {
        return name;
    }

    @Override
    public String getContentType() {
        return "Product";
    }

    @Override
    public String toString() {
        return name + ":" + " стоимость " + getCost() + "Р";


    }
}
