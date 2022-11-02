package calculator;

import exception.ExceptionMessage;
import util.StringSeparator;

import java.util.regex.Pattern;

public class StringCalculator {

    public static int calculateResult(String input) {
        checkEmptyString(input);
        checkNumber(StringSeparator.separate(input));
        return calculate(StringSeparator.separate(input));
    }

    private static int calculate(String[] splitInput) {
        int result = Integer.parseInt(splitInput[0]);
        for (int i = 2; i < splitInput.length; i += 2) {
            result = Operator.operate(splitInput[i - 1], result, Integer.parseInt(splitInput[i]));
        }
        return result;
    }

    private static void checkEmptyString(String input) {
        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.EMPTY_INPUT_EXCEPTION);
        }
    }

    private static void checkNumber(String[] splitInput) {
        final String regExp = "(^[0-9]*$)";
        for (int i = 0; i < splitInput.length; i += 2) {
            if (!Pattern.matches(regExp, splitInput[i]))
                throw new IllegalArgumentException(ExceptionMessage.INPUT_NUMBER_EXCEPTION);
        }
    } //피연산자에 대해서 숫자인지 확인할 방법이 떠오르지 않아 들여쓰기를 두번하게 됐습니다.

}
