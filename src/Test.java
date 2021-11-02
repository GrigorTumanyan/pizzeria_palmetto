import model.*;

import java.util.*;

public class Test {
    private static String filterPizzaName (Order order, String name){
        if (name.length() > 3 && name.length() < 19) {
            return name;
        } else {
            return order.getCustomer().getName() + "" + order.getNumber();
        }
    }


    public static void main(String[] args) {
        List<Ingredient> ingredientList = List.of(Ingredient.CHEESE,
                Ingredient.BACON, Ingredient.CORN, Ingredient.GARLIC, Ingredient.TOMATO_PASTE);
        Map<Ingredient, Double> ingredientDoubleMap = Pizza.addIngredient(ingredientList);


        Order order = new Order();
        Customer customer = new Customer("Grigor");
        order.setCustomer(customer);
        List<Pizza> pizzaList = new ArrayList<>();
        pizzaList.add(new Pizza(filterPizzaName(order, "asd"), ingredientDoubleMap, PizzaType.CLOSED));
        pizzaList.add(new Pizza(filterPizzaName(order, "Margarita"), ingredientDoubleMap, PizzaType.REGULAR));
        pizzaList.add(new Pizza(filterPizzaName(order, "Margarit"), ingredientDoubleMap, PizzaType.REGULAR));
        pizzaList.add(new Pizza(filterPizzaName(order, "Margarita"), ingredientDoubleMap, PizzaType.CLOSED));
        pizzaList.add(new Pizza(filterPizzaName(order, "Margarita"), ingredientDoubleMap, PizzaType.CLOSED));
        order.setOrderMap(pizzaList);


        System.out.println("ORDER:" + "" + order.getNumber());
        System.out.println("CLIENT:" + "" + customer.getNumber());


        for (Pizza pizza : pizzaList) {
            System.out.println("PizzaName:" + "" + pizza.getNAME());
        }
        System.out.println("---------------------");

        for (Ingredient ingredient : ingredientDoubleMap.keySet()) {
            System.out.println(ingredient + " " + ingredientDoubleMap.get(ingredient) + " €");
        }
        System.out.println("---------------------");
        System.out.println(order.sumPizzas(pizzaList));
        System.out.println(order.getQuantity());


    }

}
