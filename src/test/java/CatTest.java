import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)

public class CatTest {

    @Mock
    private Feline feline;

    @Test
    public void getSoundTest() {
        Cat cat = new Cat(feline);
        String actual = cat.getSound();
        Assert.assertEquals("Мяу", actual);
    }

    @Test
    public void getFoodTest() throws Exception {
        List<String> foodsExpected = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(foodsExpected);
        Cat cat = new Cat(feline);
        List<String> actualFood = cat.getFood();
        Assert.assertEquals(foodsExpected, actualFood);
    }
}