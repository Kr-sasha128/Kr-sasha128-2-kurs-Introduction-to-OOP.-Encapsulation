package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    public int basePrice;
    public int discount;

    public DiscountedProduct(String name, int basePrice, int discount) {
        super(name);
        this.basePrice = basePrice;
        this.discount = discount;
    }

    @Override
    public int getCost() {
        return basePrice * (100 - discount) / 100;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return getName() + " : " + " стоимость " + getCost() + "P " + " скидка " + discount + "%";
    }
}
