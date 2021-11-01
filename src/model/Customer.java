package model;

import annotation.Size;

import java.util.Objects;
import java.util.Random;

public class Customer {
    private int number;
    private String name;



    public Customer( String name) {
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

    {
        Random random = new Random();
        this.number = random.nextInt(10_000);
    }
}
