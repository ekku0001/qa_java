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
public class TestCat {

    @Mock
    Feline catFeline;

    @Test
    public void testGetFood(){
        try{
            Cat cat = new Cat(catFeline);
            List<String> expected = List.of("Рыбка");
            Mockito.when(catFeline.eatMeat()).thenReturn(expected);
            Assert.assertEquals(expected.get(0), cat.getFood().get(0));
        } catch (Exception exception){
            System.out.println(exception);
        }

    }

    @Test
    public void testGetSound(){
        Cat cat = new Cat(catFeline);
        Assert.assertEquals("Мяу", cat.getSound());
    }
}
