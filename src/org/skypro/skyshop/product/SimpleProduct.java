package org.skypro.skyshop.product;

public class SimpleProduct extends Product {

    private final int cost;

    public SimpleProduct(String name, int cost) {
        super(name);
        if (cost < 1) {
            throw new IllegalArgumentException(" Некорректное отображаение стоимости");
        }
        this.cost = cost;
    }

    @Override
    public int getCost() {
        return cost;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
