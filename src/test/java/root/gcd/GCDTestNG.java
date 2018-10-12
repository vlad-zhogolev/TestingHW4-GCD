package root.gcd;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by ZV on 12.10.2018.
 */
public class GCDTestNG {
    @Test(dataProvider = "data")
    public void testGcdResult(int a, int b, int expected) throws Exception {
        int result = new GCD().gcd(a, b);
        assertEquals(result, expected);

        //Maybe it would be better to create separate test for checking that
        //reminder of division a and b on result is 0
        if (result != 0) {
            assertEquals(a % result, 0);
            assertEquals(b % result, 0);
        }
        assertTrue(result >= 0);
    }

    @DataProvider(name = "data")
    public Object[][] data() {
        return new Object[][]{
                {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, 1, 1},
                {Integer.MAX_VALUE, 2, 1},
                {Integer.MAX_VALUE, 7, 1},
                {Integer.MAX_VALUE, -1, 1},
                {Integer.MAX_VALUE, -2, 1},
                {Integer.MAX_VALUE, -7, 1},
                {Integer.MAX_VALUE, 0, Integer.MAX_VALUE},

                //Test 0 with different second arguments
                {0, 0, 0},
                {0, 1, 1},
                {0, 2, 2},
                {0, 7, 7},
                {0, -1, 1},
                {0, -2, 2},
                {0, -7, 7},

                //Test that order of arguments doesn't influence the result
                {4, 512, 4},
                {8, 512, 8},
                {8, 12, 4},
                {3, 4, 1},
                {512, 4, 4},
                {512, 8, 8},
                {12, 8, 4},
                {4, 3, 1},

                {2 * 3 * 4 * 5, 2 * 3 * 7, 2 * 3},
                {5 * 5 * 13 * 17, 13 * 17 * 2, 13 * 17}};
    }
}