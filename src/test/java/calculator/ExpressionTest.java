package calculator;

import calculator.model.Expression;
import calculator.model.Operator;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class ExpressionTest {
    Expression expression1 = new Expression(1, 2, Operator.ADD);
    Expression expression2 = new Expression(100,200, Operator.ADD);
    Expression expression3 = new Expression(expression1, 10000, Operator.ADD);
    Expression expression4 = new Expression(expression1, expression2, Operator.ADD);
    Expression expression5 = new Expression(expression3, expression4, Operator.ADD);

    @Test
    void calculate_IntInt() {
        assertSimpleTest(() -> {
            int result = expression1.calculate();
            assertThat(result).isEqualTo(3);
        });
    }

    @Test
    void calculate_ExpressionInt() {
        assertSimpleTest(() -> {
            int result = expression3.calculate();
            assertThat(result).isEqualTo(10003);
        });
    }

    @Test
    void calculate_ExpressionExpression() {
        assertSimpleTest(() -> {
            int result = expression4.calculate();
            assertThat(result).isEqualTo(303);
        });
    }

    @Test
    void calculate_ExpressionExpressionAside() {
        assertSimpleTest(() -> {
            int result = expression5.calculate();
            assertThat(result).isEqualTo(10306);
        });
    }
}
