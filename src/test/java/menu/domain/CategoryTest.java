package menu.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CategoryTest {

    @Test
    @DisplayName("카테고리에 맞는 음식 이름들을 불러온다.")
    void getFoodNamesTest() {
        // given
        Category category = Category.KOREAN;
        // when
        List<String> list = category.getFoodNames();

        // then
        Assertions.assertThat(list.get(0)).isEqualTo("김밥");

    }
}