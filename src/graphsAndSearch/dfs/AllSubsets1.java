package graphsAndSearch.dfs;

import java.util.ArrayList;
import java.util.List;

public class AllSubsets1 {
    public static List<String> subSets(String set) {
        List<String> results = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(results, set, 0, sb);
        return results;
    }

    private static void dfs(List<String> result, String set, int index, StringBuilder sb) {
        if (index == set.length()) {
            result.add(sb.toString());
            return; //bug
        }

        sb.append(set.charAt(index));
        dfs(result, set, index + 1, sb);
        sb.deleteCharAt(sb.length() - 1); //bug

        dfs(result, set, index + 1, sb);
    }

    public static void main(String args[]) {
        String test = "abc";
        List<String> results = subSets(test);
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