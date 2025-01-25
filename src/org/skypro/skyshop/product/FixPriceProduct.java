package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {
    private static final int FIX_PRAIS = 99;

    public FixPriceProduct(String name) {
        super(name);
    }

    @Override
    public int getCost() {
        return FIX_PRAIS;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return getName() + ":" + " Фиксированная цена " + FIX_PRAIS + "Р";
    }
}
