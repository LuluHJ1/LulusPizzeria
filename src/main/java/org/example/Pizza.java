package org.example;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private Size size;
    private boolean stuffedCrust;
    private List<Topping> toppings = new ArrayList<>();

    public Pizza(Size size, boolean StuffedCrust) {
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
}
