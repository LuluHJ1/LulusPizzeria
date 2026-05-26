package org.example;

import java.util.ArrayList;

public class Pizza {
    private PizzaSize size;
    private CrustType crust;
    private boolean stuffedCrust;
    private ArrayList<Topping> toppings;

    public Pizza(PizzaSize size, CrustType crust, boolean stuffedCrust) {
        this.size = size;
        this.crust = crust;
        this.stuffedCrust = stuffedCrust;
        this.toppings = new ArrayList<>();
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    public double calculatePrice() {
        double total = 0;

        switch (size) {
            case PERSONAL -> total += 8.50;
            case MEDIUM -> total += 12;
            case LARGE -> total += 16.50;
        }
        if (stuffedCrust) {
            total += 3;
        }
        for (Topping t : toppings) {

            switch (t.getType()) {
                case REGULAR:
                    break;
                case PREMIUM:
                    switch (size) {
                        case PERSONAL -> total += 1;
                        case MEDIUM -> total += 2;
                        case LARGE -> total += 3;
                    }
                    break;
                case PREMIUM_EXTRA:

                    switch (size) {
                        case PERSONAL -> total += 1.50;
                        case MEDIUM -> total += 3.00;
                        case LARGE -> total += 4.50;
                    }
                    break;
            }
        }
        return total;
    }
    @Override
    public String toString() {

        String crustText;

        if(stuffedCrust) {
            crustText = " stuffed crust ";
        }else {
            crustText = "";
        }
        return size + " " + crust +
                crustText +
                " pizza with " + toppings.toString();
    }
}
