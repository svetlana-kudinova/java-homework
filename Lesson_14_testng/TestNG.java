import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class TestNG {

    @Test
    public void testFactorialZero() {
        assertEquals(Factorial.compute(0), 1);
    }

    @Test
    public void testFactorialOne() {
        assertEquals(Factorial.compute(1), 1);
    }

    @Test
    public void testFactorialFive() {
        assertEquals(Factorial.compute(5), 120);
    }

    @Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "Число не должно быть отрицательным")
    public void testFactorialNegative() {
        Factorial.compute(-1);
    }
}