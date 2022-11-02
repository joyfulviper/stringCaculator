package calculator;

import exception.ExceptionMessage;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", (num1, num2) -> num1 + num2),
    MINUS("-", (num1, num2) -> num1 - num2),
    MULTIPLY("*", (num1, num2) -> num1 * num2),
    DIVIDE("/", (num1, num2) -> {
        if (num2 == 0) {
            throw new IllegalArgumentException(ExceptionMessage.ZERO_DIVIDE_EXCEPTION);
        }
        return num1 / num2;
    });

    private final BiFunction<Integer, Integer, Integer> integerBiFunction;
    private final String symbol;

    Operator(String symbol, BiFunction<Integer, Integer, Integer> integerBiFunction) {
        this.symbol = symbol;
        this.integerBiFunction = integerBiFunction;
    }

    public static int operate(String symbol, int num1, int num2) {
        return findSymbol(symbol).integerBiFunction.apply(num1, num2);
    }

    private static Operator findSymbol(String symbol) {
        return Arrays.stream(values())
                .filter(operator -> operator.symbol.equals(symbol))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.SYMBOL_INPUT_EXCEPTION));
    }

}
