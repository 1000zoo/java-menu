package menu.domain;

public class Coach {

    private final String name;
    private final Foods disabledFoods;

    public Coach(String name, Foods disabledFoods) {
        this.name = name;
        this.disabledFoods = disabledFoods;
    }

    public boolean canEat(Food food) {
        return !disabledFoods.contains(food);
    }
}
