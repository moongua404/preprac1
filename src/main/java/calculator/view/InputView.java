package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String getSentence() {
        return getLine();
    }

    private String getLine() {
        return Console.readLine();
    }
}
