import com.example.Animal;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;


public class FelineTest {

    @Test
    public void eatMeatTest() throws Exception {
        Feline feline = new Feline();
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        List<String> actualFood = feline.eatMeat();
        Assert.assertEquals(expectedFood, actualFood);
    }

    @Test
    public void getFamilyTest() {
        Feline feline = new Feline();
        String actualFamily = feline.getFamily();
        Assert.assertEquals("Кошачьи", actualFamily);
    }

    @Test
    public void getKittensTest() {
        Feline feline = new Feline();
        int actualKittens = feline.getKittens();
        Assert.assertEquals(1, actualKittens);
    }

    @Test
    public void getKittensCountTest() {
        Feline feline = new Feline();
        int kittensCount = 3;
        int actualKittensCount = feline.getKittens(kittensCount);
        Assert.assertEquals(kittensCount, actualKittensCount);
    }

    // Проверяем выброс исключения;
    @Test
    public void testEatMeatWithUnknownAnimalKind() {
        Animal animal = new Animal();
        try {
            animal.getFood("Неизвестный вид");
        } catch (Exception exception) {
            String expectedMessage = "Неизвестный вид животного, используйте значение Травоядное или Хищник";
            String actualMessage = exception.getMessage();
            Assert.assertEquals(expectedMessage, actualMessage);
        }
    }
}

