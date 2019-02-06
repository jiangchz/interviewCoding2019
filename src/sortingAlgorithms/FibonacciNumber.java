package sortingAlgorithms;

public class FibonacciNumber {
    private static int FIRST_NUMBER = 0;
    private static int SECOND_NUMBER = 1;

    public static long getFibonacciNumber(int target) {
        if (target <= 0) {
            return FIRST_NUMBER;
        }

        if (target == 1) {
            return SECOND_NUMBER;
        }

        long previous = FIRST_NUMBER;
        long next = SECOND_NUMBER;
        long result = 0;
        while(target-- >= 2) {
            result = previous + next;
            previous = next;
            next = result;
        }
        return result;
    }

}

/*
Get the Kth number in the Fibonacci Sequence.
 (K is 0-indexed, the 0th Fibonacci number is 0 and the 1st Fibonacci number is 1).

Examples

0th fibonacci number is 0
1st fibonacci number is 1
2nd fibonacci number is 1
3rd fibonacci number is 2
6th fibonacci number is 8
Corner Cases

What if K < 0? in this case, we should always return 0.
Is it possible the result fibonacci number is overflowed?
We can assume it will not be overflowed when we solve this problem on this online judge,
but we should also know that it is possible to get an overflowed number,
and sometimes we will need to use something like BigInteger.
*/