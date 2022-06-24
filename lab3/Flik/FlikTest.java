import org.junit.Test;
import static org.junit.Assert.*;

public class FlikTest {

    @Test(timeout = 1000)
    public void FlikTest()
    {
        boolean right = true;
        boolean wrong = false;
        boolean test1 = Flik.isSameNumber(1,1);
        boolean test2 = Flik.isSameNumber(1,2);
        assertEquals(test1,right);
        assertEquals(test2, wrong);
    }
}
