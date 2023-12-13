package menu.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import menu.service.PickRandomCategory;
import menu.service.RandomRecommend;

public class MenuRecommender {

    private final Map<Coach, List<Food>> coachListMap = new HashMap<>();
    private final List<Category> categories = new ArrayList<>();

    public void setMenu(List<Coach> coaches) {
        initMap(coaches);
        for (int i = 0; i < 5; i++) {
            Category category = pickCategory();
            categories.add(category);
            recommendMenuForCoaches(coaches, category);
        }
    }

    private void initMap(List<Coach> coaches) {
        for (Coach coach : coaches) {
            coachListMap.put(coach, new ArrayList<>());
        }
    }

    private void recommendMenuForCoaches(List<Coach> coaches, Category category) {
        for (Coach coach : coaches) {
            recommendMenuForCoach(coach, category);
        }
    }

    private void recommendMenuForCoach(Coach coach, Category category) {
        Food food = RandomRecommend.pickRandomFood(coach, category);
        coachListMap.get(coach).add(food);
    }

    private Category pickCategory() {
        while (true) {
            Category category = PickRandomCategory.pickRandomCategory();
            if (tooManyPickedCategory(category)) {
                continue;
            }
            return category;
        }
    }

    private boolean tooManyPickedCategory(Category picked) {
        int count = 0;
        for (Category category : categories) {
            if (category == picked) {
                count++;
            }
        }
        return count >= 2;
    }

    @Override
    public String toString() {
        return "MenuRecommender{\n" +
                "categories=" + categories +
                "\ncoachListMap=" + coachListMap +
                '}';
    }
}
