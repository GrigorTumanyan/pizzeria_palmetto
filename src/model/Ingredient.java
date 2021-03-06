package model;

public enum Ingredient {

    TOMATO_PASTE(1), CHEESE(1), SALAMI(1.5), BACON(1.2), GARLIC(0.3), CORN(0.7),
    PEPPERONI(0.6), OLIVES(0.5), BUTTER(1), ITALIAN_CHESS(1), MAYONNAISE(1);
    public double price;

    Ingredient(double price) {
        this.price = price;
    }
}