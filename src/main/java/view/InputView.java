package view;

import java.util.Scanner;

public class InputView {
    private final static String INPUT_MESSAGE = "문자열을 입력해주세요";
    private final static Scanner scanner = new Scanner(System.in);

    public static String getString() {
        System.out.println(INPUT_MESSAGE);
        return scanner.nextLine();
    }
}
