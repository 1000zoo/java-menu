package menu.domain;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MenuRecommenderTest {

    @Test
    @DisplayName("카테고리 맵 테스트")
    void categoriesMapTest() {
        // given
        Coach coach1 = new Coach("jj");
        coach1.addDisabledFood(new Food("김밥"));
        coach1.addDisabledFood(new Food("우동"));
        Coach coach2 = new Coach("jk");
        coach1.addDisabledFood(new Food("하이라이스"));
        coach1.addDisabledFood(new Food("동파육"));

        // when
        MenuRecommender menuRecommender = new MenuRecommender();
        menuRecommender.setMenu(new Coaches(List.of(coach1, coach2)));
        // then

        System.out.println(menuRecommender);

    }

}