import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class HelloTest {

    @Test
    public void testGreet() {
        Hello h = new Hello();
        assertEquals("Hello", h.greet());
    }

}