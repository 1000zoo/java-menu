package menu.domain;

import java.util.List;

public class Coach {

    private final String name;
    private final List<Food> disabledFoods;

    public Coach(String name, List<Food> disabledFoods) {
        this.name = name;
        this.disabledFoods = disabledFoods;
    }
}
