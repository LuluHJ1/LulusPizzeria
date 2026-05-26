package org.example;

public class PriceHelper {

    public static double getBasePrice(Size size) {
        switch (size) {
            case PERSONAL: return 8.50;
            case MEDIUM: return 12.50;
            case LARGE: return 16.50;
        }
        return 0;
    }
    public static double getToppingPrice(Topping t, Size size) {
        if (t.getType() == Topping.Type.REGULAR ||
        t.getType() == Topping.Type.SAUCE ||
        t.getType() == Topping.Type.SIDE) {
            return 0.0; // REGULAR
        }
        if (t.getType() == Topping.Type.MEAT) {
            if(!t.isExtra()) {
                switch (size) {
                    case PERSONAL: return 1.00;
                    case MEDIUM: return 2.00;
                    case LARGE: return 3.00;
                }
            } else {
                switch (size) {
                    case PERSONAL: return 0.50;
                    case MEDIUM: return 1.00;
                    case LARGE: return 1.50;
                }
            }
        }
        if (t.getType() == Topping.Type.CHEESE) {
            if (!t.isExtra()) {
                switch (size) {
                    case PERSONAL: return 0.75;
                    case MEDIUM: return 1.50;
                    case LARGE: return 2.25;
                }
            } else {
                switch (size) {
                    case PERSONAL: return 0.30;
                    case MEDIUM: return 0.60;
                    case LARGE: return 0.90;
                }
            }
        }
        return 0;
    }
}
