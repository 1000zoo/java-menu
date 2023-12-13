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

    private Coaches coaches;

    public void setMenu(Coaches coaches) {
        initMap(coaches);
        this.coaches = coaches;
        for (int i = 0; i < 5; i++) {
            Category category = pickCategory();
            categories.add(category);
            recommendMenuForCoaches(coaches, category);
        }
    }

    private void initMap(Coaches coaches) {
        for (Coach coach : coaches.coaches()) {
            coachListMap.put(coach, new ArrayList<>());
        }
    }

    private void recommendMenuForCoaches(Coaches coaches, Category category) {
        for (Coach coach : coaches.coaches()) {
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

    public List<String> categoryList() {
        return categories.stream().map(Category::getCategoryName).toList();
    }

    public Map<String, List<String>> recommendedMenu() {
        Map<String, List<String>> map = new HashMap<>();
        List<String> coachNames = coaches.coachNames();
        for (String coach : coachNames) {
            map.put(coach, coachListMap.get(new Coach(coach)).stream().map(Food::name).toList());
        }
        return map;
    }

    @Override
    public String toString() {
        return "MenuRecommender{\n" +
                "categories=" + categories +
                "\ncoachListMap=" + coachListMap +
                '}';
    }
}
