package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    public int basePrice;
    public int discount;

    public DiscountedProduct(String name, int basePrice, int discount) {
        super(name);
        if (basePrice < 1) {
            throw new IllegalArgumentException(" Некорректное отображаение стоимости");
        }
        this.basePrice = basePrice;
        if (discount >= 0 && discount <= 100) {
            this.discount = discount;
        } else {
            throw new IllegalArgumentException(" Ошибка выведения скидки");
        }
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
