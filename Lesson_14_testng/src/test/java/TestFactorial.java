
import org.junit.jupiter.api.DisplayName;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class TestFactorial {

    private final Factorial calculator = new Factorial();

    @Test
    @DisplayName("Факториал нуля")
    public void testFactorialZero() {
        assertEquals(calculator.compute(0), 1);
    }

    @Test
    @DisplayName("Факториал единицы")
    public void testFactorialOne() {
        assertEquals(calculator.compute(1), 1);
    }

    @Test
    @DisplayName("Факториал пяти")
    public void testFactorialFive() {
        assertEquals(calculator.compute(5), 120);
    }

    @Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "Число не должно быть отрицательным")
    public void testFactorialNegative() {
        calculator.compute(-1);
    }
}
