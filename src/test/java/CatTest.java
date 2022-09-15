import com.example.Cat;
import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    @Mock
    Feline feline;

    @Test
    public void catGetSoundTest() {
        Cat cat = new Cat(feline);
        assertEquals("Мяу", cat.getSound());

    }

    @Test
    public void testCatMethodGetFoodException() throws Exception {
        try {
            Cat cat = new Cat(feline);
            Mockito.when(feline.eatMeat()).thenThrow(new Exception("Неизвестный вид животного, используйте значение Травоядное или Хищник"));
            cat.getFood();
        } catch (Exception exception) {
            assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", exception.getMessage());
        }
    }
}
