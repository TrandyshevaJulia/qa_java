import com.example.FelineInterface;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.util.List;


public class LionTest {

    @Mock
    FelineInterface feline;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getKittensTest() throws Exception {
        Mockito.when(feline.getKittens()).thenReturn(1);
        Lion lion = new Lion("Самец", feline); // Создаем объект Lion с полом и моком FelineInterface
        int actualKittens = lion.getKittens();
        Assert.assertEquals(1, actualKittens);
    }

    @Test
    public void getFoodTest() throws Exception {
        List<String> foodsExpected = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(foodsExpected);
        Lion lion = new Lion("Самец", feline); // Создаем объект Lion с полом
        List<String> actualFood = lion.getFood();
        Assert.assertEquals(foodsExpected, actualFood);
    }

    // Проверяем выброс исключения;
    @Test
    public void sexThrowsExceptionTest() {
        try {
            new Lion("InvalidSex", feline);
            Assert.fail("Будет выдано исключение");
        } catch (Exception exception) {
            Assert.assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
        }
    }
}










