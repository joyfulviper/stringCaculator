package util;

import calculator.StringCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
public class StringCalculatorTest {

    @DisplayName("입력받은 값에 대해서 정확한 연산을 수행하는지 확인하는 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1 + 2 / 3 : 1", "2 + 3 * 4 / 2 : 10", "3 * 4 + 8 / 2 : 10"}, delimiter = ':')
    public void 연산결과_확인_테스트(String input, int output) {
        assertThat(StringCalculator.calculateResult(input)).isEqualTo(output);
    }
}
