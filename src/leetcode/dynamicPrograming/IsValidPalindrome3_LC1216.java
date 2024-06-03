package leetcode.dynamicPrograming;

public class IsValidPalindrome3_LC1216 {
    public boolean isValidPalindrome(String s, int k) {
        char[] chars = s.toCharArray();
        int maxLen = longestPalindrome(chars);
        return maxLen + k >= s.length();
    }

    //LC516 马甲
    private int longestPalindrome(char[] chars) {
        int m = chars.length;
        if (m <= 1) {
            return m;
        }

        int[][] dp = new int[m][m];

        for (int len = 1; len <= m; len++) {
            for (int i = 0; i < m && i + len <= m; i++) {
                int j = i + len - 1;
                if (i == j) {
                    dp[i][j] = 1;
                } else if (chars[i] == chars[j]) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][m -1];
    }
}


/**
 * Given a string s and an integer k, return true if s is a k-palindrome.
 *
 * A string is k-palindrome if it can be transformed into a palindrome by removing at most k characters from it.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcdeca", k = 2
 * Output: true
 * Explanation: Remove 'b' and 'e' characters.
 * Example 2:
 *
 * Input: s = "abbababa", k = 1
 * Output: true
 */
