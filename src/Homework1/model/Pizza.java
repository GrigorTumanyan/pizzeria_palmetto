package Homework1.model;



import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public final class  Pizza  {
    private final String NAME;
    private final Map<Ingredient, Double> INGREDIENT;
    private final PizzaType PIZZATYPE;


    public Pizza(String NAME, Map<Ingredient, Double> INGREDIENT, PizzaType PIZZATYPE) {
        this.NAME = NAME;
        this.INGREDIENT = INGREDIENT;
        this.PIZZATYPE = PIZZATYPE;
    }

    public String getNAME() {
        return NAME;
    }

    public Map<Ingredient, Double> getINGREDIENT() {
        return INGREDIENT;
    }

    public PizzaType getPIZZATYPE() {
        return PIZZATYPE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pizza pizza = (Pizza) o;
        return Objects.equals(NAME, pizza.NAME)  && PIZZATYPE == pizza.PIZZATYPE;
    }

    @Override
    public int hashCode() {
        return Objects.hash(NAME, PIZZATYPE);
    }

    public static Map<Ingredient, Double> addIngredient(List<Ingredient> ingredientList) {
        Map<Ingredient, Double> ingredientMap = new HashMap<>();
        for (Ingredient nextIngredient : ingredientList) {
            if (ingredientMap.containsKey(nextIngredient)) {
                System.err.println("Check your order again");
            }if (nextIngredient.ordinal() == 10){
                System.err.println("Pizza is full");
            }
            ingredientMap.put(nextIngredient, nextIngredient.price);
        }
        return ingredientMap;
    }
}