package calculator;

import calculator.model.Separator;
import calculator.service.CalculateService;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class calculateServiceTest {
    CalculateService calculateService = new CalculateService();
    Separator separator = new Separator();

    @Test
    public void getSeparatorTest() {
        calculateService.getSeparator("//^\\", separator);
    }

    @Test
    public void getSeparatorExceptionTest() {
        assertSimpleTest(() -> {
            boolean res = calculateService.getSeparator("//\\", separator);
            assertThat(res == false).isTrue();
        });
    }
}
