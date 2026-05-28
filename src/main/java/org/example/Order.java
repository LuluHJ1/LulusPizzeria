package org.example;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<Pizza> pizzas = new ArrayList<>();
    private List<Drink> drinks = new ArrayList<>();
    private int garlicKnots = 0;

    public void addPizza(Pizza pizza) {

        //  NEW CODE LEARNED ADDING 0 ADDS TO TOP
        pizzas.add(0, pizza);
    }
    public void addDrink (Drink drink) {
        drinks.add(0, drink);
    }
    public void addGarlicKnots (int quantity) {
        garlicKnots += quantity;
    }
    public List<Pizza> getPizzas() {
        return pizzas;
    }
    public List<Drink> getDrinks() {
        return drinks;
    }
    public int getGarlicKnots() {
        return garlicKnots;
    }
    public double calculateTotal() {
        double total = 0;

        for (Pizza p : pizzas) {
            total += p.calculatePrice();
        }
        for (Drink d : drinks) {
            total += d.getPrice();
        }
        total += garlicKnots * 1.50;

        return total;
    }
    public String formatReceipt() {
        StringBuilder receipt = new StringBuilder();

        receipt.append("==== ORDER RECEIPT ====\n\n");

        for(Pizza p : pizzas) {
            receipt.append(p).append("\n\n");
        }
        for(Drink d : drinks) {
            receipt.append(d).append("\n\n");
        }
        if (garlicKnots > 0) {
            receipt.append("Garlic Knots x").append(garlicKnots);
            receipt.append(" = $").append(String.format("%.2f", garlicKnots * 1.50)).append("\n");
        }
        receipt.append("\nTOTAL: $").append(String.format("%.2f", calculateTotal()));

        return receipt.toString();
    }
}
