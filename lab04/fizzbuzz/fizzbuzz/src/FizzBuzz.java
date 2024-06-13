import java.util.Scanner;   /// imports 

public class FizzBuzz {
    public String fizzBuzz(int n) {     
        if (n % 3 == 0) {
            return "Fizz";
        } else if (n % 3 == 0 && n % 5 == 0) {
            return "FizzBuzz";
        } else if (n % 5 == 0) {
            return "Buzz";
        } else {
            return String.valueOf(n);     /// return value 
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);    /// scanner 
        System.out.print("Enter a number for the FizzBuzz app: ");
        int number = scanner.nextInt();
        FizzBuzz fizzBuzz = new FizzBuzz();    ///create object
        System.out.println(fizzBuzz.fizzBuzz(number));   /// print number using class method 
        scanner.close();   
    }
}