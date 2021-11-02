package model;

import java.util.Random;

public class Customer {
    private final int number;
    private String name;

    {
        Random random = new Random();
        this.number = random.nextInt(10_000);
    }

    public Customer() {
    }

    public Customer(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
