package org.example;

public class GarlicKnots {

    private int quantity;
    private final double price = 1.50;

    public GarlicKnots(int quantity) {
        this.quantity = quantity;
    }
    public int getQuantity() {
        return quantity;
    }

    public double calculatePrice() {
        return quantity * price;
    }

    @Override
    public String toString () {
        return "Garlic Knots x" +
                quantity +
                "-$" +
                calculatePrice();
    }
}
