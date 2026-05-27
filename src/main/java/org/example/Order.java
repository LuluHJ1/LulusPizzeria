package org.example;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<Pizza> pizzas = new ArrayList<>();
    private List<Drink> drinks = new ArrayList<>();
    private int garlicKnots = 0;

    public void addPizza(Pizza pizza) {
        pizzas.add(pizza);
    }
    public void addDrink (Drink drink) {
        drinks.add(drink);
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
        String receipt = "";

        receipt += "==== ORDER RECEIPT ====\n\n";

        for(Pizza p : pizzas) {
            receipt += p.toString() + "\n\n";
        }
        for(Drink d : drinks) {
            receipt += d.toString() + "\n\n";
        }
        if (garlicKnots > 0) {
            receipt += "Garlic Knots x" + garlicKnots;
            receipt += " = $" + (garlicKnots * 1.50) + "\n";
        }
        receipt += "\nTOTAL: $" + calculateTotal();

        return receipt;
    }
}
