package calculator.controller;

import calculator.model.Expression;
import calculator.model.Operator;
import calculator.model.Separator;
import calculator.service.CalculateService;
import calculator.view.InputView;
import calculator.view.OutputView;
import utils.ConstantMessage;
import utils.ConstantValue;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

public class CalculatorController {
    InputView inputView;
    OutputView outputView;
    CalculateService calculateService;

    private static final String EMPTY_STRING = "";
    private static final List<Character> INITIAL_CHAR = List.of(',', ';');

    public CalculatorController(InputView inputView, OutputView outputView, CalculateService calculateService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.calculateService = calculateService;
    }

    public void run() throws Exception {
        while (true) {
            try {
                mainLogic();
                break;
            } catch (Exception exception) {
                handleException(exception);
            }
        }
    }

    private void mainLogic() {
        Separator separator = new Separator(INITIAL_CHAR);
        Expression expression = getInput(separator);
        getResult(expression);
    }

    private void handleException(Exception exception) throws Exception {
        outputView.printMessage(exception.getMessage());
        if (exception.getClass() == NoSuchElementException.class) {
            throw exception;
        }
    }

    private Expression getInput(Separator separator) {
        outputView.printGuide(ConstantMessage.START_GUIDE_MESSAGE);
        String sentence = inputView.getSentence();
        if (Objects.equals(sentence, EMPTY_STRING)) {
            throw new NoSuchElementException(ConstantMessage.EMPTY_INPUT.getMessage());
        }
        return getExpression(separator, sentence);
    }

    private void getResult(Expression expression) {
        int result = expression.calculate();
        outputView.printResult(result);
    }

    private Expression getExpression(Separator separator, String sentence) {
        boolean isSeperated = calculateService.getSeparator(sentence, separator);
        if (isSeperated) {
            sentence = sentence.substring(ConstantValue.EXPRESSION_START.get());
        }
        return parseToExpression(splitSentence(separator, sentence));
    }

    private List<String> splitSentence(Separator separator, String sentence) {
        return List.of(sentence.split(separator.getRegex()));
    }

    private Expression parseToExpression(List<String> sentences) {
        Expression expression = new Expression(0, 0, Operator.ADD);
        for (String value : sentences) {
            expression = new Expression(expression, parseInt(value), Operator.ADD);
        }
        return expression;
    }

    private int parseInt(String value) {
        try {
            int parsed = Integer.parseInt(value);
            isNegative(parsed);
            return parsed;
        } catch (Exception exception) {
            throw new IllegalArgumentException(ConstantMessage.INVALID_NUMBER.getMessage());
        }
    }

    private void isNegative(int value) {
        if (value < 0) {
            throw new NumberFormatException();
        }
    }
}
