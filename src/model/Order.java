package model;


import java.util.*;

public class Order {
    private int number;
    private Customer custmor;
    private Map<Pizza, Integer> pizzaMap;
    private int quantity;

    public Order() {
    }

    public Order(Customer custmor, Map<Pizza, Integer> pizzaMap) {
        this.custmor = custmor;
        this.pizzaMap = pizzaMap;
    }

    public void setCustmor(Customer custmor) {
        this.custmor = custmor;
    }

    public void setPizzaMap(List<Pizza> pizzas) {
        addPizza(pizzas);
    }

    public int getNumber() {
        return this.number;
    }

    public Customer getCustmor() {
        return custmor;
    }

    public Map<Pizza, Integer> getPizzaMap() {
        return pizzaMap;
    }

    public int getQuantity() {
        return quantity;
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

    public double sumPizzaType(List<Pizza> pizzas){
        double sum = 0;
        for (Pizza pizza : pizzas) {
            sum +=pizza.getPIZZATYPE().price;
        }
        return sum;
    }

    public double sumPizzas(List<Pizza> pizzas){
       return sumIngredient(pizzas) + sumPizzaType(pizzas);
    }


    public double sumTotal(double pizzaValue){
        return pizzaValue;
    }
    public double sumTotal(double pizzaValue,double pizzaValue1){
        return pizzaValue + pizzaValue1;
    }
    public double sumTotal(double pizzaValue, double pizzaValue1, double pizzaValue2){
        return pizzaValue + pizzaValue1 + pizzaValue2;
    }

    private void orderNumber (){
        Random random = new Random();
        this.number = random.nextInt(10_000,100_000);
    }

    private void orderQuantity (){
        for (Integer value : pizzaMap.values()) {
            this.quantity += value;
        }
    }
    private void addPizza (List <Pizza> pizzas){
      Map<Pizza, Integer> pizzasMap = new HashMap<>();
        for (Pizza pizza : pizzas) {
            if (!pizzasMap.containsKey(pizza)){
                pizzasMap.put(pizza,1);
            }else {
                pizzasMap.put(pizza,pizzasMap.get(pizza) + 1);
            }
        }
        this.pizzaMap = pizzasMap;
        orderQuantity();
        orderNumber();
    }
//    public double sumIngredientPrice(Map<Ingredient, Double> ingredientDoubleMap) {
//        double sum = 0;
//        for (Ingredient ingredient : ingredientDoubleMap.keySet()) {
//            sum += ingredientDoubleMap.get(ingredient);
//        }
//        return sum;
//    }

}
