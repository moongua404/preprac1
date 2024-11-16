package calculator.model;

import java.util.List;

public class Expression {
    Expression firstExpression;
    int firstValue;
    Expression secondExpression;
    int secondValue;
    Operator operator;

    public int calculate() {
        if (firstExpression != null) {
            firstValue = firstExpression.calculate();
        }
        if (secondExpression != null) {
            secondValue = secondExpression.calculate();
        }
        return operator.calculate(firstValue, secondValue);
    }

    public Expression(int first, int second, Operator operator) {
        this.firstValue = first;
        this.secondValue = second;
        this.operator = operator;
    }

    public Expression(Expression first, int second, Operator operator) {
        this.firstExpression = first;
        this.secondValue = second;
        this.operator = operator;
    }

    public Expression(Expression first, Expression second, Operator operator) {
        this.firstExpression = first;
        this.secondExpression = second;
        this.operator = operator;
    }
}
