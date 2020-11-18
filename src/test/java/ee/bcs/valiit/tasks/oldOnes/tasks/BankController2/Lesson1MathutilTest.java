package ee.bcs.valiit.tasks.oldOnes.tasks.BankController2;

import ee.bcs.valiit.tasks.oldOnes.tasks.Lesson1MathUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Lesson1MathutilTest {

    @Test
    public void min2_testWithWholePositiveNumbers_returnsResult() {
        Assertions.assertEquals(2, Lesson1MathUtil.min2(2, 3));
    }

    @Test
    public void doubleTest_testDecimals_returnsResult() {
        double a = 1.0;
        double b = 1.0;
        assertEquals(a, b, 0.0000001);
    }

    @Test
    public void max() {
        assertEquals(26, Lesson1MathUtil.max2(13, 26));
    }

    @Test
    public void abs() {
        assertEquals(7, Lesson1MathUtil.abs(-7));
    }

    @Test
    public void isEven() {
        assertEquals(false, Lesson1MathUtil.isEven(7));
    }

    @Test
    public void min3() {
        assertEquals(6, Lesson1MathUtil.min3(6, 7, 124));
    }

    @Test
    public void max3() {
        assertEquals(124, Lesson1MathUtil.max3(6, 7, 124));
    }


}
