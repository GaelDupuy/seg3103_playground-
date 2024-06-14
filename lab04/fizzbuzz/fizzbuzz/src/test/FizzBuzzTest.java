import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class FizzBuzzTest {
    private final FizzBuzz fizzBuzz = new FizzBuzz();

    @Test
    public void testFizzBuzz() {
        assertEquals("FizzBuzz", fizzBuzz.fizzBuzz(15));
        assertEquals("Fizz", fizzBuzz.fizzBuzz(3));
        assertEquals("Buzz", fizzBuzz.fizzBuzz(5));
        assertEquals("4", fizzBuzz.fizzBuzz(4));
        assertEquals("7", fizzBuzz.fizzBuzz(7));
        assertEquals("FizzBuzz", fizzBuzz.fizzBuzz(0)); // this test failed 
    }
}