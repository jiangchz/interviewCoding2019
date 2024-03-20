package leetcode.dfs;

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


    public static List<String> subSets2(String set) {
        List<String> result = new ArrayList<>();
        if (set == null) {
            return result;
        }
        StringBuilder sb = new StringBuilder();
        subSetsHelper(set, sb, result, 0);
        return result;
    }
    private static void subSetsHelper(String set,
                               StringBuilder sb,
                               List<String> result,
                               int index) {
        if (index == set.length()) {
            result.add(sb.toString());
            return;
        }
        sb.append(set.charAt(index));//bug
        subSetsHelper(set, sb, result, index + 1);
        sb.deleteCharAt(sb.length() - 1);//bug
        subSetsHelper(set, sb, result, index + 1);//bug
    }

    public static void main(String args[]) {
        String test = "abc";
        List<String> results = subSets2(test);
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