package org.example;

public class Drink {
    private String flavor;
    private DrinkSize drinkSize;

    public Drink(String flavor, DrinkSize size) {
        this.flavor = flavor;
        this.drinkSize = size;
    }
    public double getPrice() {

        switch (drinkSize) {
            case SMALL:
                return 2.00;

            case MEDIUM:
                return 2.50;
            case LARGE:
                return 3.00;
        }
        return 0;
    }
}
