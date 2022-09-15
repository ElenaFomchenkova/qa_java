import com.example.Feline;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class FelineTest {
    Feline feline = new Feline();
    @Test
    public void eatMeatShouldReturnPredatorFoodTest() throws Exception {
        Feline feline1 = Mockito.spy(feline);
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline1.getFood("Хищник")).thenReturn(expected);
        List<String> actual = feline1.eatMeat();
        assertEquals(expected, actual);
    }

    @Test
    public void getKittensTest() {
        assertEquals(1, feline.getKittens());
    }

    @Test
    public void getFamilyTest() {
        assertEquals("Кошачьи", feline.getFamily());
    }
}
