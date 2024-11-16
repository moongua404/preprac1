package calculator.view;

import utils.ConstantMessage;

public class OutputView {
    public void printGuide(ConstantMessage constants) {
        System.out.println(constants.getMessage());
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printResult(int resultValue) {
        System.out.println(String.format(ConstantMessage.RESULT_GUIDE_MESSAGE.getMessage(), resultValue));
    }
}
