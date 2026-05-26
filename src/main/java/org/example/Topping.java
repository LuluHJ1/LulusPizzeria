package org.example;

public class Topping {

    private String name;
    private ToppingType type;
    private double

    public Topping(String name, ToppingType type) {
        this.name = name;
        this.type = type;
    }
    public ToppingType getType(){
        return type;
    }
    @Override
    public String toString(){
        return name;
    }
}
