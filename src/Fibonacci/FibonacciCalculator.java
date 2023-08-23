package Fibonacci;

public class FibonacciCalculator {
    public static long getFibonacciProduct(long numbersOfFibonacci) {
        int counter = 1;
        long product = 1;
        long currentNumber = 1;
        long previousNumber = currentNumber;
        while (counter <= numbersOfFibonacci) {
            long nextNumber = previousNumber + currentNumber;
            previousNumber = currentNumber;
            currentNumber = nextNumber;
            counter++;
            product = product + nextNumber;
        }
        return product;
    }
}
