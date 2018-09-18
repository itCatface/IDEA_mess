package util.lang.number;

public class Algorithm {

    /**
     * the pythagorean theorem
     */
    public static final double pythagorean(double value1, double value2) {
        return Math.sqrt((value1 * value1) + (value2 * value2));
    }


    /**
     * Fibonacci: f(0) = 0; f(1) = 1; f(n) = f(n -1) + f(n - 2) [n >= 2, n belongs to N*]
     */
    public static long fibonacci(long number) {
        long one = 0;
        long two = 1;
        long three;
        for (long w = 2; w < number; w++) {
            three = one + two;
            one = two;
            two = three;
        }

        return one + two;
    }
}
