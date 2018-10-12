package root.gcd;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

/**
 * Created by ZV on 12.10.2018.
 */
@RunWith(Parameterized.class)
public class GCDTest {
    @Test
    public void gcdTest() throws Exception {
        int result = new root.gcd.GCD().gcd(a, b);
        assertEquals(result, expected);
        if (result != 0) {
            assertEquals(a % result, 0);
            assertEquals(b % result, 0);
        }
        assertTrue(result >= 0);
    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                //Check MAX_VALUE and MIN_VALUE with different second arguments
                //Function won't work right with at least one argument equal to Integer.MIN_VALUE
                //because MIN_VALUE can't be converted to corresponding positive value
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
                {5 * 5 * 13 * 17, 13 * 17 * 2, 13 * 17}
        });
    }

    @Parameter(0)
    public int a;

    @Parameter(1)
    public int b;

    @Parameter(2)
    public int expected;
}