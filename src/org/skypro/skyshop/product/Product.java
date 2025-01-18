package org.skypro.skyshop.product;

public abstract class Product {
    private String name;

    public String getName() {
        return name;
    }

    public abstract int getCost();

    public boolean isSpecial() {
        return false;
    }


    public Product(String name) {
        this.name = name;

    }

    @Override
    public String toString() {
        return name + ":" + " стоимость " + getCost() + "Р";
    }
}
