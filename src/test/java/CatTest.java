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

    @Test(expected = Exception.class)
    public void testCatMethodGetFoodException() throws Exception {
        Cat cat = new Cat(feline);
        String actual = String.valueOf(Mockito.when(feline.eatMeat()).thenThrow(new Exception("Неизвестный вид животного, используйте значение Травоядное или Хищник")));
        cat.getFood();
        assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", actual);
    }
    //убрала try catch
}
