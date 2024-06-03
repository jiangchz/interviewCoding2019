package leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

public class RemoveInvalidParentheses_LC301 {
    public List<String> removeInvalidParentheses(String s) {
        char[] check =  {'(', ')'};
        List<String> result = new ArrayList<>();
        char[] source = s.toCharArray();
        dfs(source, result, check, 0, 0);
        return result;
    }

    private void dfs(char[] source, List<String> result, char[] check, int lastLeft, int lastRight) {
        int count = 0;
        int right = lastRight;

        while (right < source.length && count >= 0) {
            if (source[right] == check[0]) {
                count++;
            } else if (source[right] == check[1]) {
                count--;
            }
            right++;
        }

        // no extra ')' is detected. We now have to detect extra '(' by reversing the string.
        if (count >= 0) {
            char[] reversed = reverseCopy(source);
            if (check[0] == '(') {
                dfs(reversed, result, new char[]{')', '('}, 0, 0);
            } else { //we finished forward and backward check, now we need to add result at the end of backward check
                result.add(String.valueOf(reversed));
            }
        } else { //  extra ')' is detected. We have to fix it
            right = right - 1; //'i-1' is the index of abnormal ')', the substring taking to next recursion is from [lastLeft - (right - 1)]
            for (int left = lastLeft; left <= right; left++) {
                if (source[left] == check[1] && (left == lastLeft || source[left - 1] != check[1])) {//found one protential removed breaket, for case like "()(()", we only want to count remove index 2 but not index 3 to avoid duplicate
                    char[] updatedSource = removeIndex(source, left);
                    dfs(updatedSource, result, check, left, right);
                }
            }
        }
    }

    private char[] removeIndex(char[] source, int index) {
        char[] copy = new char[source.length - 1];
        for (int i = 0, j = 0; i < source.length; i++) {
            if (i == index) {
                continue;
            }
            copy[j++] = source[i];
        }
        return copy;
    }

    private char[] reverseCopy(char[] source) {
        char[] copy = new char[source.length];
        for (int i = 0; i < source.length; i++) {
            copy[source.length - i - 1] = source[i];
        }
        return copy;
    }
}

/**
 * Given a string s that contains parentheses and letters, remove the minimum number of invalid parentheses to make the input string valid.
 *
 * Return a list of unique strings that are valid with the minimum number of removals. You may return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "()())()"
 * Output: ["(())()","()()()"]
 * Example 2:
 *
 * Input: s = "(a)())()"
 * Output: ["(a())()","(a)()()"]
 * Example 3:
 *
 * Input: s = ")("
 * Output: [""]
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 25
 * s consists of lowercase English letters and parentheses '(' and ')'.
 * There will be at most 20 parentheses in s.
 */