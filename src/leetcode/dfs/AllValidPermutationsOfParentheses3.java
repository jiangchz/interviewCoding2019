package leetcode.dfs;

import java.util.*;

public class AllValidPermutationsOfParentheses3 {

    private static final char[] BREAKETS = new char[]{'(', ')', '<','>','{','}'};

    public List<String> validParenthesesIII(int l, int m, int n) {
        int total = 2 * (l + m + n);
        int[] remains = new int[]{l, l, m, m, n, n};
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        Stack<Integer> unmatched = new Stack<>();
        dfs(0, sb, result, total, remains, unmatched);
        return result;
    }

    private void dfs(int index, StringBuilder sb, List<String> result, int total, int[] remains, Stack<Integer> unmatched) {
        if (index == total) {
            result.add(sb.toString());
            return;
        }

        for (int i = 0; i < BREAKETS.length; i++) {
            char c = BREAKETS[i];
            //left breaket
            if (i % 2 == 0) {
                if (remains[i] > 0 && (unmatched.isEmpty() || unmatched.peek() > i)) {
                    sb.append(c);
                    remains[i]--;
                    unmatched.push(i);
                    dfs(index + 1, sb, result, total, remains, unmatched);
                    unmatched.pop();
                    remains[i]++;
                    sb.setLength(sb.length() - 1);
                }
            } else {
                if (remains[i] > 0 && !unmatched.isEmpty() && unmatched.peek() + 1 == i) {
                    sb.append(c);
                    remains[i]--;
                    unmatched.pop();
                    dfs(index + 1, sb, result, total, remains, unmatched);
                    unmatched.push(i - 1);
                    remains[i]++;
                    sb.setLength(sb.length() - 1);
                }
            }
        }
    }
    public static void main(String[] args) {
        AllValidPermutationsOfParentheses3 permutations = new AllValidPermutationsOfParentheses3();
        List<String> result = permutations.validParenthesesIII(2,0, 1);
        for (String s : result) {
            System.out.println(s);
        }
    }
}
/*
Get all valid permutations of l pairs of (), m pairs of <> and n pairs of {}.

Assumptions

l, m, n >= 0
Examples

l = 1, m = 1, n = 0, all the valid permutations are ["()<>", "(<>)", "<()>", "<>()"]


 */