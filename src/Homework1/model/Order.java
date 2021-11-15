package Homework1.model;


import java.util.*;

public class Order {
    private int number;
    private Customer customer;
    private Map<Pizza, Integer> pizzaMap;
    private int quantity;

    public Order() {
        orderNumber();
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setPizzaMap(List<Pizza> pizzaMap) {
        addPizza(pizzaMap);
    }

    public int getNumber() {
        return this.number;
    }

    public int getQuantity() {
        return quantity;
    }

    public double sumPizzaType(List<Pizza> pizzas) {
        double sum = 0;
        for (Pizza pizza : pizzas) {
            sum += pizza.getPIZZATYPE().price;
        }
        return sum;
    }

    public double sumIngredient(List<Pizza> pizzas) {
        double sum = 0;
        for (Pizza pizza : pizzas) {
            Map<Ingredient, Double> ingredient = pizza.getINGREDIENT();
            for (Double value : ingredient.values()) {
                sum += value;
            }
        }
        return sum;
    }

    public double sumPizzas(List<Pizza> pizzas) {
        return sumIngredient(pizzas) + sumPizzaType(pizzas);
    }

    public double sumTotal(double pizzaValue) {
        return pizzaValue;
    }

    public double sumTotal(double pizzaValue, double pizzaValue1) {
        return pizzaValue + pizzaValue1;
    }

    public double sumTotal(double pizzaValue, double pizzaValue1, double pizzaValue2) {
        return pizzaValue + pizzaValue1 + pizzaValue2;
    }

    private void orderNumber() {
        Random random = new Random();
        this.number = random.nextInt(10_000, 100_000);
    }

    private void orderQuantity() {
        for (Integer value : pizzaMap.values()) {
            this.quantity += value;
        }
    }

    private void addPizza(List<Pizza> pizzas) {
        Map<Pizza, Integer> pizzaMap = new HashMap<>();
        for (Pizza pizza : pizzas) {
            if (!pizzaMap.containsKey(pizza)) {
                pizzaMap.put(pizza, 1);
            } else {
                pizzaMap.put(pizza, pizzaMap.get(pizza) + 1);
            }
        }
        this.pizzaMap = pizzaMap;
        orderQuantity();
    }
}

