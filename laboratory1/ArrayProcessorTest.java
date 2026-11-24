package laboratory1;

import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayProcessorTest {

    @Test
    public void testSumOfNegatives() {
        int[] array = {3, -2, 5, -1, 0, -4};
        // -2 + (-1) + (-4) = -7
        assertEquals(-7, ArrayProcessor.sumOfNegatives(array));
    }

    @Test
    public void testProductBetweenMinMax() {
        // min = -5 (індекс 1), max = 10 (індекс 5). Між ними: 4, 2, 3
        // Добуток: 4 * 2 * 3 = 24
        int[] array = {1, -5, 4, 2, 3, 10};
        assertEquals(24, ArrayProcessor.productBetweenMinMax(array));
    }

    // Тест на виключну ситуацію: порожній масив
    @Test(expected = IllegalArgumentException.class)
    public void testEmptyArrayException() {
        int[] array = {};
        ArrayProcessor.sumOfNegatives(array);
    }

    // Тест на виключну ситуацію: немає елементів між min/max
    @Test(expected = ArithmeticException.class)
    public void testNoElementsBetweenMinMaxException() {
        int[] array = {10, -5}; // min і max стоять поруч, між ними нічого немає
        ArrayProcessor.productBetweenMinMax(array);
    }
}
