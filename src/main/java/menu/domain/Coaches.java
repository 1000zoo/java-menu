package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Coaches {

    private final List<Coach> coaches = new ArrayList<>();

    public void addCoach(Coach coach) {
        if (coaches.contains(coach)) {
            throw new IllegalArgumentException();
        }
        coaches.add(coach);
    }
}
