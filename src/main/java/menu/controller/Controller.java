package menu.controller;

import java.util.List;
import java.util.Map;
import menu.domain.Coaches;
import menu.domain.MenuRecommender;
import menu.view.Output;

public class Controller {

    private final static Output output = new Output();

    private final MenuRecommender menuRecommender = new MenuRecommender();

    public void start() {
        output.print("점심 메뉴 추천을 시작합니다.");
        Coaches coaches = readCoaches();
        menuRecommender.setMenu(coaches);

        printResult();
        output.print("추천을 완료했습니다.");
    }

    private void printResult() {
        List<String> categoryNames = menuRecommender.categoryList();
        Map<String, List<String>> recommendedMenu = menuRecommender.recommendedMenu();

        output.print("메뉴 추천 결과입니다.\n"
                + "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        output.print(formatting("카테고리", categoryNames));
        for (String coachName : recommendedMenu.keySet()) {
            output.print(formatting(coachName, recommendedMenu.get(coachName)));
        }
    }

    private String formatting(String row, List<String> informations) {
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(formatting(row));
        for (String information : informations) {
            sb.append("|").append(formatting(information));
        }
        sb.append("]");
        return sb.toString();
    }

    private String formatting(String str) {
        return " " + str + " ";
    }

    private Coaches readCoaches() {
        CoachController controller = new CoachController();
        return controller.readCoaches();
    }

}
