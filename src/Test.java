import model.*;

import java.util.*;

public class Test {
//    private static String getPizzaName (String name){
//        String pizzaName;
//        if (name.length() > 19 || name.length() < 3) {
//            pizzaName = order.getCustmor().getName() + order.getNumber();
//        } else {
//            pizzaName = name;
//        }
//        return pizzaName;
//    }

    public static void main(String[] args) {
        List<Ingredient> ingredientList = List.of(Ingredient.CHEESE,
                Ingredient.BACON, Ingredient.CORN, Ingredient.GARLIC, Ingredient.TOMATO_PASTE);
        Map<Ingredient, Double> ingredientDoubleMap = Pizza.addIngredient(ingredientList);


        Order order = new Order();
        List<Pizza> pizzaList = new ArrayList<>();
        pizzaList.add(new Pizza("Margarit", ingredientDoubleMap, PizzaType.CLOSED));
        pizzaList.add(new Pizza("Margarita", ingredientDoubleMap, PizzaType.REGULAR));
        pizzaList.add(new Pizza("Margarit", ingredientDoubleMap, PizzaType.REGULAR));
        pizzaList.add(new Pizza("Margarita", ingredientDoubleMap, PizzaType.CLOSED));
        pizzaList.add(new Pizza("Margarita", ingredientDoubleMap, PizzaType.CLOSED));
        Customer customer = new Customer("Grigor");
        order.setCustmor(customer);
        order.setPizzaMap(pizzaList);

        System.out.println("ORDER:" + "" + order.getNumber());
        System.out.println("CLIENT:" + "" + customer.getNumber());
        Map<Pizza, Integer> pizzaMap = order.getPizzaMap();
        for (Pizza pizza : pizzaMap.keySet()) {
            System.out.println("NAME:" + "" + pizza.getNAME());
        }
        System.out.println("---------------------");

        for (Ingredient ingredient : ingredientDoubleMap.keySet()) {
            System.out.println(ingredient  + " " + ingredientDoubleMap.get(ingredient) + " €");
        }
        System.out.println("---------------------");
        System.out.println(order.sumPizzas(pizzaList));
        System.out.println(order.getQuantity());



//        Pizza pizza = new Pizza("Margarit",ingredientDoubleMap,PizzaType.CLOSED);
//        Pizza pizza1 = new Pizza("Margarita",ingredientDoubleMap,PizzaType.REGULAR);
//        Pizza pizza2 = new Pizza("Margarit",ingredientDoubleMap,PizzaType.CLOSED);
//
//        Customer customer = new Customer("Grigor");
//        Order order = new Order();
//        order.setCustmor(customer);
//        order.addPizza(List.of(pizza, pizza1, pizza2));
//        order.orderNumber();
//        order.orderQuantity();
//        System.out.println(order.getNumber());
//        System.out.println(order.getQuantity());


//        Pizza pizza = new Pizza(getPizzaName("Margarita"),ingredientDoubleMap, PizzaType.CLOSED);
//        Customer customer = new Customer(45789, "Grigor");
//        Order order = new Order(78945, customer,pizza,2);


//        IngredientServiceImpl ingredientService = new IngredientServiceImpl();
//        Map<Ingredient, Double> ingredientDoubleMap = ingredientService.addIngredient(List.of(Ingredient.CHEESE,
//                Ingredient.BACON, Ingredient.CORN,Ingredient.GARLIC,Ingredient.TOMATO_PASTE,Ingredient.OLIVES,
//                Ingredient.PEPPERONI,Ingredient.SALAMI,Ingredient.MAYONNAISE,Ingredient.ITALIAN_CHESS, Ingredient.BUTTER));
//        System.out.println(ingredientDoubleMap);

//        Pizza pizza = new Pizza();
//        pizza.setPizzaType(PizzaType.CLOSED);
//        pizza.setName("M");
//        pizza.setIngredient(ingredientDoubleMap);
//        System.out.println(pizza);
//


//        IngredientServiceImpl ingredientService = new IngredientServiceImpl();
//        Map<Ingredient, Double> ingredientDoubleMap = ingredientService.addIngredient(List.of(Ingredient.CHEESE, Ingredient.BACON, Ingredient.CORN));
//        double amountIngredientPrice = ingredientService.amountIngredientPrice(List.of(Ingredient.CHEESE, Ingredient.BACON, Ingredient.CORN));
//        System.out.println(ingredientDoubleMap);
//        System.out.println(amountIngredientPrice);
//        System.out.println(ingredientService.amountIngredientPrice(ingredientDoubleMap));
//        System.out.println(ingredientDoubleMap);
//        double sum = 0;
//        for (Ingredient ingredient : ingredientDoubleMap.keySet()) {
//           sum += ingredientDoubleMap.get(ingredient);
//        }
//        System.out.println(sum);

    }

}
