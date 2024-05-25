import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EvenTest {
    @Test
    public void testCheckEven() {
        int input = 0b0110010;
        int expectedOutput = Integer.bitCount(input);

        assertEquals(expectedOutput, 3);
    }
}
