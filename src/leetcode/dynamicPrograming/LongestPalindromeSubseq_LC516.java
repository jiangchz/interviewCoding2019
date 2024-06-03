package leetcode.dynamicPrograming;

public class LongestPalindromeSubseq_LC516 {
    public int longestPalindromeSubseq(String s) {
        int totalLen = s.length();
        char[] chars = s.toCharArray();
        //Array stores the longest palindrome
        int[][] dp = new int[totalLen][totalLen];


        for (int len = 1; len <= totalLen; len++) {
            for (int i = 0; i <= totalLen - len; i++) {
                int j = i + len - 1;
                if (i == j) {
                    dp[i][j] = 1;
                } else if (chars[i] == chars[j]) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }

            }
        }
        return dp[0][totalLen - 1];
    }

    public int longestPalindromeSubseq_memo(String s) {
        char[] chars = s.toCharArray();
        Integer[][] memo = new Integer[chars.length][chars.length];
        return helper(chars, memo, 0, chars.length - 1);
    }

    private int helper(char[] chars, Integer[][] memo, int start, int end) {
        if (memo[start][end] != null) {
            return memo[start][end];
        }

        if (start > end) {
            return 0;
        }

        if (start == end) {
            return 1;
        }

        if (chars[start] == chars[end]) {
            memo[start][end] = helper(chars, memo, start + 1, end - 1) + 2;
        } else {
            memo[start][end] = Math.max(helper(chars, memo, start + 1, end), helper(chars, memo, start, end - 1));
        }
        return memo[start][end];

    }
}
/**
 * Given a string s, find the longest palindromic subsequence's length in s.
 *
 * A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "bbbab"
 * Output: 4
 * Explanation: One possible longest palindromic subsequence is "bbbb".
 * Example 2:
 *
 * Input: s = "cbbd"
 * Output: 2
 * Explanation: One possible longest palindromic subsequence is "bb".
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * s consists only of lowercase English letters.
 */
