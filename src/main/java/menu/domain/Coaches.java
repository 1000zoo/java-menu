package menu.domain;

import java.util.Collections;
import java.util.List;

public class Coaches {

    private final List<Coach> coaches;

    public Coaches(List<Coach> coaches) {
        this.coaches = coaches;
    }

    public List<Coach> coaches() {
        return Collections.unmodifiableList(coaches);
    }

    public List<String> coachNames() {
        return coaches.stream().map(Coach::getName).toList();
    }
}
