import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class TestLion {
    @Mock
    Feline lionFeline;


    @Test
    public void testLionInvalidSex(){
        try{
            Lion lion = new Lion(lionFeline, "X");
        } catch (Exception exception){
            Assert.assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
        }

    }

    @Test
    public void  testGetKittens(){
        try{
            int expKittens = 10;
            Lion lion = new Lion(lionFeline, "Самец");
            Mockito.when(lionFeline.getKittens()).thenReturn(expKittens);
            Assert.assertEquals(expKittens, lion.getKittens());
        } catch (Exception exception){
            System.out.println(exception);
        }
    }

    @Test
    public void  testGetFood(){
        try{
            Lion lion = new Lion(lionFeline, "Самка");
            List<String> expected = List.of("Мясо");

            Mockito.when(lionFeline.getFood(Mockito.anyString())).thenReturn(expected);
            Assert.assertEquals(expected.get(0), lion.getFood().get(0));
        } catch (Exception exception){
            System.out.println(exception);
        }
    }
}
