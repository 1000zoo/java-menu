package menu.domain;

import java.util.List;

public class Coach {

    private final String name;
    private final List<Food> foods;

    public Coach(String name, List<Food> foods) {
        this.name = name;
        this.foods = foods;
    }
}
