package menu.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Coach {

    private final String name;
    private final List<Food> disabledFoods = new ArrayList<>();

    public Coach(String name) {
        validate(name);
        this.name = name;
    }

    public void addDisabledFood(Food food) {
        if (disabledFoods.contains(food)) {
            throw new IllegalArgumentException();
        }
        disabledFoods.add(food);
    }

    private void validate(String name) {
        if (name.length() < 2 || name.length() > 4) {
            throw new IllegalArgumentException();
        }
    }

    public boolean canEat(Food food) {
        return !disabledFoods.contains(food);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Coach coach = (Coach) o;
        return Objects.equals(name, coach.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Coach{" +
                "name='" + name + '\'' +
                '}';
    }
}
