package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Food;

public class RandomRecommend {

    public static Food pickRandomFood(Coach coach, Category category) {
        List<String> foodNames = category.getFoodNames();

        while (true) {
            String foodName = Randoms.shuffle(foodNames).get(0);
            Food food = new Food(foodName);
            if (coach.canEat(food)) {
                return food;
            }
        }
    }
}
