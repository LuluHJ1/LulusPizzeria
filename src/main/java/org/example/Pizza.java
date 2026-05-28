package org.example;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private Size size;
    private boolean stuffedCrust;
    private CrustType crustType;
    private List<Topping> toppings = new ArrayList<>();

    public Pizza(Size size, boolean stuffedCrust) {
        this.size = size;
        this.stuffedCrust = stuffedCrust;

    }
    public void setCrustType(CrustType crustType) {
        this.crustType = crustType;
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }
    public Size getSize() {
        return size;
    }
    public List<Topping> getToppings() {
        return toppings;
    }
    public boolean hasStuffedCrust() {
        return stuffedCrust;
    }

    public double calculatePrice() {
        double total = PriceHelper.getBasePrice(size);

       for (Topping t : toppings) {
           total += PriceHelper.getToppingPrice(t, size);
            }
        return total;
    }
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(size).append(" Pizza\n");

        if (stuffedCrust) {
            result.append("Stuffed Crust\n");
        }
        result.append("Toppings:\n");

        for (Topping  t : toppings) {
            result.append("- ").append(t.getName());

            if (t.isExtra()) {
                result.append("(extra)");
            }
            result.append("\n");
        }
            result.append("Price: $").append(calculatePrice());
            return result.toString();
    }
}
