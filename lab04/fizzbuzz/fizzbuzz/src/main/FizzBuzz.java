public class FizzBuzz {     
    public String fizzBuzz(int n) {     
        if (n == 0) {                                 // check for 0
            return "Fizz";
        } else if (n % 3 == 0 && n % 5 == 0) {     // check of 3 and 5 
            return "FizzBuzz";
        } else if (n % 3 == 0) {                    // check for multiples of 3 
            return "Fizz";
        } else if (n % 5 == 0) {
            return "Buzz";                          // check for multiples of 5
        } else {
            return String.valueOf(n);              // return result 
        }
    }

    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz();
        System.out.println(fizzBuzz.fizzBuzz(0)); // Should print "FizzBuzz"
    }
}