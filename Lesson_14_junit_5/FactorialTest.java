import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class FactorialTest {
    @Test
    @DisplayName("Факториал нуля")
    public void testFactorialOfZero() throws IllegalArgumentException {
        Assertions.assertEquals(1, Factorial.compute(0));
    }

    @Test
    @DisplayName("Факториал единицы")
    public void testFactorialOfOne() throws IllegalArgumentException {
        Assertions.assertEquals(1, Factorial.compute(1));
    }

    @Test
    @DisplayName("Факториал пяти")
    public void testFactorialOfTwelve() throws IllegalArgumentException {
        Assertions.assertEquals(120, Factorial.compute(5));
    }

    @Test
    @DisplayName("Факториал отрицательного числа")
    public void testFactorialOfNegative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Factorial.compute(-1);
        });
    }
}
