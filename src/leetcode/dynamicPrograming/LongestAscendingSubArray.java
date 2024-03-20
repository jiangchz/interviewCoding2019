package leetcode.dynamicPrograming;

public class LongestAscendingSubArray {
    public int longest(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int gobalMax = 1;
        int previous = 1;
        for (int index = 1; index < array.length; index++) {
            if (array[index] > array[index - 1]) {
                previous++;
            } else {
                previous = 1;
            }
            gobalMax = Math.max(previous, gobalMax);
        }
        return gobalMax;
    }
}
/*
Given an unsorted leetcode.array, find the length of the longest subarray in which the numbers are in ascending order.

Assumptions

The given leetcode.array is not null
Examples

{7, 2, 3, 1, 5, 8, 9, 6}, longest ascending subarray is {1, 5, 8, 9}, length is 4.

{1, 2, 3, 3, 4, 4, 5}, longest ascending subarray is {1, 2, 3}, length is 3.




M[i]: the longest ascending order of the first i elements
baseCase: M[0] = 1;
induction rule:
               case1 : leetcode.array[i] > leetcode.array[i - 1]
                     M[i] = M[i - 1] + 1
               case2:
                     M[i] = 1
 */