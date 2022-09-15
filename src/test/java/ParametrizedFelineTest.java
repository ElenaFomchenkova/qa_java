import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class ParametrizedFelineTest {
    Feline feline = new Feline();
    private final int kittensCount;
    private int expected;

    public ParametrizedFelineTest(int kittensCount, int expected) {
        this.kittensCount = kittensCount;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {1, 1},
                {0, 0},
                {105, 105},
        };
    }

    @Test
    public void getKittensIntTest() {
        assertEquals(expected, feline.getKittens(kittensCount));
    }

}
