package org.example;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private Size size;
    private boolean stuffedCrust;
    private List<Topping> toppings = new ArrayList<>();

    public Pizza(Size size, boolean stuffedCrust) {
        this.size = size;
        this.stuffedCrust = stuffedCrust;

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
        String result = "";
        result += size + " Pizza\n";

        if (stuffedCrust) {
            result += "Stuffed Crust\n";
        }
        result += "Toppings:\n";

        for (Topping  t : toppings) {
            result += "- " + t.getName();

            if (t.isExtra()) {
                result += "(extra)";
            }
            result += "\n";
        }
            result += "Price: $" + calculatePrice();
            return result;
    }
}
