package org.example;

public class Drink {
    private String name;
    private double price;

    public Drink(String name,double price) {
        this.name = name;
        this.price = price;
    }
    @Override
    public double calculatePrice() {
        return price;
    }
}
