import com.example.FelineInterface;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

@RunWith(Parameterized.class)
public class LionParameterizedTest {

    @Mock
    FelineInterface feline;

    private final String sex;
    private final boolean doesHaveMane;

    @Parameterized.Parameters
    public static Object[][] getGenderData() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false}
        };
    }

    public LionParameterizedTest(String sex, boolean doesHaveMane) {
        this.sex = sex;
        this.doesHaveMane = doesHaveMane;
    }

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void doesHaveManeTest() throws Exception {
        Lion lion = new Lion(sex, feline);  // Создаем объект Lion с полом и моком FelineInterface
        Assert.assertEquals(doesHaveMane, lion.doesHaveMane());
    }
}
