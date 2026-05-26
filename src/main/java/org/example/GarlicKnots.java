package org.example;

public class GarlicKnots {
    private String name;
    private double price;

    public GarlicKnots(String name,double price) {
        this.name = name;
        this.price = price;
    }
    @Override
    public double calculatePrice() {
        return price;
    }
}
