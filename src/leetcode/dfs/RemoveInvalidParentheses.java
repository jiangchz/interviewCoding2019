package leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

public class RemoveInvalidParentheses {
    private static final char[] PAIR = new char[]{'(', ')'};
    private static final char[] REVERSE_PAIR = new char[]{')', '('};
    public List<String> removeInvalidParentheses(String s) {
        List<String> results = new ArrayList<>();
        removeHelper(s, results, 0, 0, PAIR);
        return results;
    }

    private void removeHelper(String s, List<String> results, int lastI, int lastJ, char[] pair) {
        int i;
        int j;
        int stack = 0;
        for (i = lastI; i < s.length(); i++) {
            if (s.charAt(i) == pair[0]) {
                stack++;
            }

            if (s.charAt(i) == pair[1]) {
                stack--;
            }

            if (stack >= 0) {
                continue;
            }

            for (j = lastJ; j <= i; j++) {
                if (s.charAt(j) != pair[1]) {
                    continue;
                }
                if (j == lastJ || s.charAt(j - 1) != pair[1]) {
                    removeHelper(s.substring(0, j) + s.substring(j + 1), results, i, j, pair);
                }
            }
            return;
        }

        String reversed = new StringBuilder(s).reverse().toString();
        if (pair[0] == PAIR[0]) {
            // left to right
            removeHelper(reversed, results, 0, 0, REVERSE_PAIR);
        } else {
            //finished doing a right to left and ready to put the result to results leetcode.array
            results.add(reversed);
        }
    }
}
