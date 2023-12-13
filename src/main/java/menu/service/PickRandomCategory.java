package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.Category;

public class PickRandomCategory {

    public static Category pickRandomCategory() {
        int randomId = Randoms.pickNumberInRange(1, 5);
        return Category.findById(randomId);
    }
}
