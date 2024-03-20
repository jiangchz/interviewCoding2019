package leetcode.sortingAlgorithms;

public class AtoThePowerOfB {
    public static long getAToThePowerOfB(int base, int power) {
        if (base == 1 || base == 0) {
            return base;
        }
        if (power == 0) {
            return 1;
        }

        long result = base;
        while(power-- > 1) {
            result *= base;
        }
        return result;
    }
    public static void main(String args[]) {
        int base = -2;
        int power = 3;
        System.out.println(getAToThePowerOfB(base, power));
    }

}

/*
Evaluate a to the power of b, assuming both a and b are integers and b is non-negative.

Examples

power(2, 0) = 1
power(2, 3) = 8
power(0, 10) = 0
power(-2, 5) = -32
Corner Cases

What if the result is overflowed?
We can assume the result will not be overflowed when we solve this problem on this online judge.

*/