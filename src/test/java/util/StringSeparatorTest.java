package util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringSeparatorTest {

    @DisplayName("입력받은 문자열을 분리하는 테스트")
    @Test
    public void 문자열_분리_테스트() {
        assertThat(StringSeparator.separate("1 + 2 / 3")).containsExactly("1", "+", "2", "/", "3");
    }
}
