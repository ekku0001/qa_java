import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


@RunWith(Parameterized.class)
public class TestLionHasMane{

    private final String sex;
    private final boolean expectedMane;

    public TestLionHasMane(String sex, boolean expectedMane) {
        this.sex = sex;
        this.expectedMane = expectedMane;
    }


    @Parameterized.Parameters
    public static Object[] getInputData() {
        return new Object[][] {
                { "Самец",  true },
                { "Самка", false },
        };
    }

    @Test
    public void  testDoesHaveMane(){
        try {
            Lion lion = new Lion(new Feline(), sex);
            Assert.assertEquals( expectedMane, lion.doesHaveMane());
        }catch (Exception exception){
            System.out.println(exception);
        }
    }

}
