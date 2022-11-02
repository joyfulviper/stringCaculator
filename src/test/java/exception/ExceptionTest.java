package exception;

import calculator.StringCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ExceptionTest {

    @DisplayName("입력 값이 공백일 경우 예외발생 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"  ", " ", ""})
    public void 입력_값이_공백일_경우_테스트(String input) {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> StringCalculator.calculateResult(input));
        assertThat(e.getMessage()).isEqualTo("입력 값이 비어있습니다.");
    }

    @DisplayName("연산기호가 올바르지 않을 경우 예외발생 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1 & 2", "1 + 2 & 3", "1 ( 2"})
    public void 연산기호가_올바르지_않을_경우_테스트(String input) {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> StringCalculator.calculateResult(input));
        assertThat(e.getMessage()).isEqualTo("연산기호가 올바르지 않습니다.");
    }

    @DisplayName("0으로 나누었을 경우 예외발생 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"2 / 0", "1 * 2 / 0", "3 + 2 / 0"})
    public void 나누기를_0으로_했을_경우_테스트(String input) {
        IllegalArgumentException e = assertThrows((IllegalArgumentException.class), () -> StringCalculator.calculateResult(input));
        assertThat(e.getMessage()).isEqualTo("0으로 나눌 수 없습니다.");
    }

    @DisplayName("입력값이 숫자가 아닐경우 예외발생 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"a / b", "% / 4", "* / +"})
    public void 입력값이_숫자가_아닐경우_테스트(String input) {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> StringCalculator.calculateResult(input));
        assertThat(e.getMessage()).isEqualTo("피연산자는 숫자만 가능합니다.");
    }
}
