import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class FizzBuzzTest {
    private final FizzBuzz fizzBuzz = new FizzBuzz();

    @Test
    public void testFizzBuzz() {
        assertEquals("FizzBuzz", fizzBuzz.fizzBuzz(15));   // to test a multiple of both 5 and 3 
        assertEquals("Fizz", fizzBuzz.fizzBuzz(3));          // to test a multiple of 3 
        assertEquals("Buzz", fizzBuzz.fizzBuzz(5));             // to test a multiple of 5 
        assertEquals("4", fizzBuzz.fizzBuzz(4));             // to test a number not a multiple of 3 5 
        assertEquals("7", fizzBuzz.fizzBuzz(7));            // to test a number not a multiple of 3 5 
        assertEquals("FizzBuzz", fizzBuzz.fizzBuzz(0)); // this test failed first time, works now 
    }
}