package calculator;

import calculator.controller.CalculatorController;
import calculator.service.CalculateService;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        CalculateService calculateService = new CalculateService();
        CalculatorController calculatorController = new CalculatorController(
                inputView,
                outputView,
                calculateService
        );

        try {
            calculatorController.run();
        } catch (Exception exception) {
            ;
        }
    }
}
