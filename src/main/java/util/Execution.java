package util;

import calculator.StringCalculator;
import view.InputView;
import view.OutputView;

public class Execution {
    public static void run() {
        String input = InputView.getString();
        int result = StringCalculator.calculateResult(input);
        OutputView.printResult(result);
    }
}
