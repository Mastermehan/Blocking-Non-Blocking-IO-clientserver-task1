public class Calculate {
    static long Fibonacci(int number) {
        long maxNumber = 0;
        long previousNumber = 0;
        long nextNumber = 1;

        for (int i = 1; i <= number; ++i) {
            maxNumber = previousNumber + nextNumber;
            previousNumber = nextNumber;
            nextNumber = maxNumber;
        }
        return maxNumber;
    }
}

