package model;


import java.util.*;

public class Order {
    private int number;
    private Customer customer;
    private Map<Order, Integer> orderMap;
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

    public void setOrderMap(List<? extends Order> orders) {
        addOrder(orders);
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
        for (Integer value : orderMap.values()) {
            this.quantity += value;
        }
    }

    private void addOrder(List<? extends Order> orders) {
        Map<Order, Integer> orderMap = new HashMap<>();
        for (Order order : orders) {
            if (!orderMap.containsKey(order)) {
                orderMap.put(order, 1);
            } else {
                orderMap.put(order, orderMap.get(order) + 1);
            }
        }
        this.orderMap = orderMap;
        orderQuantity();
    }
}

