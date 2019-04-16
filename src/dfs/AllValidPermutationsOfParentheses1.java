package dfs;

import java.util.ArrayList;
import java.util.List;

public class AllValidPermutationsOfParentheses1 {
    public static List<String> validParentheses(int n) {
        List<String> results = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(results, n, 0, 0, sb);
        return results;
    }

    private static void dfs(List<String> result, int n, int left, int right, StringBuilder sb) {
        if (left == n && right == n) {
            result.add(sb.toString());
        }

        if (left < n) {
            sb.append("{");
            dfs(result, n, left + 1, right, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (right < left) {
            sb.append("}");
            dfs(result, n, left, right + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String args[]) {
        List<String> results = validParentheses(10);
        for (String result : results) {
            System.out.println(result);
        }
    }
}

/*
Given a set of characters represented by a String, return a list containing all subsets of the characters.

Assumptions

There are no duplicate characters in the original set.
​Examples

Set = "abc", all the subsets are [“”, “a”, “ab”, “abc”, “ac”, “b”, “bc”, “c”]
Set = "", all the subsets are [""]
Set = null, all the subsets are []

Two bugs:
1. Forget to return at leaf level
2. remove char at length - 1
 */