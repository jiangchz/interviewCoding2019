package leetcode.dynamicPrograming;

public class LongestAscendingSubSequence {
    //常规dp解，liner scan 回头看，
    //liner scan扫一遍O(n)，对于每个点，需要再回头看之前存的最大值O(n)，总的复杂度为O(n^2)
    public int longest(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        //dp[i]的物理意义： 包括index为i在内的最长升序的长度
        int[] dp = new int[array.length];
        int max = 1;
        for (int i = 0; i < array.length; i++) {
            //如果在i之前没有比i小的最长升序，
            //那么index i作为目前升序的开始，所以dp[i] = 1;
            dp[i] = 1;//bug!!!
            for (int j = 0; j < i; j++) {
                if (array[i] > array[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(dp[i], max);
                }
            }
        }
        return max;
    }

    //最优解 https://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/
    public int longest2(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int[] refinedValue = new int[array.length + 1];
        refinedValue[1] = array[0];
        int result = 1;
        for (int i = 1; i < array.length; i++) {
            int index = searchIndex(refinedValue, array[i], result);
            if (result == index) {
                refinedValue[++result] = array[i];
            } else {
                refinedValue[index + 1] = array[i];
            }
        }
        return result;

    }
    private int searchIndex(int[] refinedValue, int target, int endIndex) {
        int left = 0;
        int right = endIndex;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (refinedValue[mid] > target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (refinedValue[right] < target) {
            return right;
        } else {
            return left;
        }
    }



}
/*
Given an unsorted leetcode.array, find the length of the longest subsequence in which the numbers are in ascending order.

Assumptions

The given leetcode.array is not null

 */