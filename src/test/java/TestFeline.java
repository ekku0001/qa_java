import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;


@RunWith(MockitoJUnitRunner.class)
public class TestFeline {

    @Spy
    Feline feline;

    @Test
    public void testEatMeat() {
        try{
            List<String> food = feline.eatMeat();
            Assert.assertEquals( "Животные", food.get(0));
        } catch (Exception e){
            System.out.println(e);
        }
    }

    @Test
    public void testGetFamily() {
        Assert.assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void testGetKittensWithoutArg() {
        feline.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens(1);
    }

    @Test
    public void testGetKittensWithArg() {
        int kittens = 5;
        Assert.assertEquals(kittens, feline.getKittens(kittens));
    }
}
