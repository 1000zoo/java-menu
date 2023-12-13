package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Foods {

    private final List<Food> foods;

    private Foods(List<Food> foods) {
        this.foods = foods;
    }

    public static Foods of(List<String> names) {
        List<Food> foods = new ArrayList<>();
        for (String name : names) {
            foods.add(new Food(name));
        }
        return new Foods(foods);
    }

    public List<String> getFoodNames() {
        List<String> names = new ArrayList<>();
        for (Food food : foods) {
            names.add(food.name());
        }
        return names;
    }
}
