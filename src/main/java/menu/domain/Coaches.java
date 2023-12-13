package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Coaches {

    private final List<Coach> coaches;

    private Coaches(List<Coach> coaches) {
        this.coaches = coaches;
    }

    public static Coaches of(List<String> coachNames) {
        validate(coachNames);
        List<Coach> coaches = new ArrayList<>();
        for (String name : coachNames) {

        }
        return null;
    }

    private static void validate(List<String> coachNames) {
        if (coachNames.size() < 2 || coachNames.size() > 5) {
            throw new IllegalArgumentException();
        }
    }

}
