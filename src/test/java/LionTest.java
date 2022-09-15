import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;

    @Test(expected = Exception.class)
    public void invalidLionSexTest() {
      try { Lion lion = new Lion("Undefined", feline);}
      catch (Exception e) {throw new RuntimeException(e);}
    }

    @Test
    public void checkingFemaleLionTest() throws Exception {
        MockitoAnnotations.openMocks(this);
        Lion lion = new Lion("Самка", feline);
        boolean actual = lion.doesHaveMane();
        assertEquals(false, actual);
    }

    @Test
    public void checkingMaleLionTest() throws Exception {
        MockitoAnnotations.openMocks(this);
        Lion lion = new Lion("Самец", feline);
        boolean actual = lion.doesHaveMane();
        assertEquals(true, actual);
    }

    @Test
    public void getFoodShouldReturnPredatorFoodTest() throws Exception {
        Lion Lion = new Lion("Самец", feline);
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expected);
        List<String> actual = Lion.getFood();
        assertEquals(expected, actual);
    }

    @Test
    public void getKittensTest() throws Exception {
        Lion Lion = new Lion("Самец", feline);
        int expected = 1;
        Mockito.when(feline.getKittens()).thenReturn(expected);
        int actual = Lion.getKittens();
        assertEquals(expected, actual);
    }
}
