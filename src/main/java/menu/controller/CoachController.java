package menu.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import menu.domain.Coach;
import menu.domain.Coaches;
import menu.domain.Food;
import menu.view.Input;

public class CoachController {

    private final Input input = new Input();
    private List<Coach> coachList = new ArrayList<>();

    public Coaches readCoaches() {
        createUntilValid();
        setDetails();
        return new Coaches(coachList);
    }

    private void setDetails() {
        for (Coach coach : coachList) {
            setCoachDetailUntilValid(coach);
        }
    }

    private void setCoachDetailUntilValid(Coach coach) {
        try {
            setCoachDetail(coach);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            coach.clear();
            setCoachDetailUntilValid(coach);
        }
    }

    private void setCoachDetail(Coach coach) {
        System.out.println(coach.getName() + "이(가) 못 먹는 메뉴를 입력해 주세요.");
        List<String> disabledFoodNameList = stringToList(input.readLine());
        validateFoodNameList(disabledFoodNameList);
        for (String foodName : disabledFoodNameList) {
            Food food = new Food(foodName);
            coach.addDisabledFood(food);
        }
    }

    private void validateFoodNameList(List<String> disabledFoodNameList) {
        if (disabledFoodNameList.size() > 2) {
            throw new IllegalArgumentException("못먹는 음식은 최대 2개까지 입니다.");
        }
    }

    private void createUntilValid() {
        try {
            createCoaches();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            createUntilValid();
        }
    }

    private void createCoaches() {
        System.out.println("코치의 이름을 입력해 주세요.");
        List<String> nameList = stringToList(input.readLine());
        validateNameList(nameList);
        for (String name : nameList) {
            Coach coach = new Coach(name);
            if (coachList.contains(coach)) {
                coachList.clear();
                throw new IllegalArgumentException("같은 이름이 포함되어있습니다.");
            }
            coachList.add(new Coach(name));
        }
    }

    private void validateNameList(List<String> nameList) {
        if (nameList.size() < 2 || nameList.size() > 5) {
            throw new IllegalArgumentException("코치는 2명 이상, 5명 이하여야 합니다.");
        }
    }

    private List<String> stringToList(String string) {
        return Arrays.stream(string.split(",")).toList();
    }
}
