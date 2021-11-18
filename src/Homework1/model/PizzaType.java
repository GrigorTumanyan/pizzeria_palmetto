package Homework1.model;

public enum PizzaType {
    REGULAR(1.0), CLOSED(1.5);
    public double price;

    PizzaType(double price) {
        this.price = price;
    }
}
