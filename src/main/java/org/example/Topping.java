package org.example;

public class Topping {

    public enum Type {
        MEAT,CHEESE, REGULAR,SAUCE,SIDE
    }
    private String name;
    private Type type;
    private boolean extra;

    public Topping(String name, Type type, boolean extra) {
        this.name = name;
        this.type = type;
        this.extra = extra;
    }
    public String getName(){
        return name;
    }
    public Type getType() {
        return type;
    }
    public boolean isExtra() {
        return extra;
    }

}
