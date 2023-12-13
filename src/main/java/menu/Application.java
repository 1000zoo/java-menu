package menu;

import menu.controller.CoachController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        CoachController controller = new CoachController();
        controller.readCoaches();

    }
}
