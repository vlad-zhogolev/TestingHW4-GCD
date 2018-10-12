package root.sqrt;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by ZV on 12.10.2018.
 */
public class AdvSqrtTest {

    private static double precision = 0.00000001;

    @Test(dataProvider = "data")
    public void testSqrt(double a, double expected) throws Exception {
        double result = new root.sqrt.AdvSqrt().sqrt(a);
        if (Double.isFinite(expected))
            assertTrue(Math.abs(result - expected) < precision);
        else
            assertEquals(result, expected);
    }

    @DataProvider
    public Object[][] data() {
        return new Object[][]{
                {0.0 / 0.0, Double.NaN},
                {1.0 / 0.0, Double.POSITIVE_INFINITY},
                {-1.0 / 0.0, Double.NaN},
                {2.0, Math.sqrt(2.0)},
                {4.0, 2.0},
                {-1, Double.NaN},
                {0.0, 0.0},
                {1.0, 1.0},
                {Double.longBitsToDouble(0x0001000000000000L), Math.sqrt(Double.longBitsToDouble(0x0001000000000000L))}
        };
    }
}