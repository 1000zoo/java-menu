package menu.domain;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MenuRecommenderTest {

    @Test
    @DisplayName("카테고리 맵 테스트")
    void categoriesMapTest() {
        // given
        Coach coach1 = new Coach("jj", Foods.of(List.of("김밥", "우동")));
        Coach coach2 = new Coach("jk", Foods.of(List.of("하이라이스", "탕수육")));
        // when
        MenuRecommender menuRecommender = new MenuRecommender();
        menuRecommender.setMenu(List.of(coach1, coach2));
        // then

        System.out.println(menuRecommender);

    }

}