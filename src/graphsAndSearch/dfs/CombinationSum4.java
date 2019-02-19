package graphsAndSearch.dfs;

import java.util.Arrays;

public class CombinationSum4 {

    public static void main(String args[]) {
        int[] numbers = {1, 2, 3, 6 , 7, 8};
        System.out.println(getCombinationNumbers(numbers, 20));
        System.out.println(getCombinationNumbersV2(numbers, 20));
    }

    public static int getCombinationNumbers(int[] numbers, int target) {
        int[] sortedNumbers = Arrays.copyOf(numbers, numbers.length);
        Arrays.sort(sortedNumbers);

        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int index = 1; index <= target; index++) {
            for (int currentNumber : numbers) {
                if (index - currentNumber < 0) {
                    break;
                }
                dp[index] += dp[index - currentNumber];
            }
        }
        return dp[target];
    }

    public static int getCombinationNumbersV2(int[] numbers, int target) {
        int[] sortedNumbers = Arrays.copyOf(numbers, numbers.length);
        Arrays.sort(sortedNumbers);

        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int index = 0; index <= target; index++) {
            for (int currentNumber : numbers) {
                if (index + currentNumber > target) {
                    break;
                }
                dp[index + currentNumber] += dp[index];
            }
        }
        return dp[target];
    }
}

/*
 Combination Sum IV
Given an integer array with all positive numbers and no duplicates,
find the number of possible combinations that add up to a positive integer target.

Example:

nums = [1, 2, 3]
target = 4

The possible combination ways are:
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)

Note that different sequences are counted as different combinations.

Therefore the output is 7.

Summary:
Data: Feb 3rd, 2019
时间 O(N^2) 空间 O(N)
*/