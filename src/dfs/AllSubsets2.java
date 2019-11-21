package dfs;

import java.util.ArrayList;
import java.util.List;

public class AllSubsets2 {

    public static List<String> subSets(String set) {
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
            return; //bug!!!!
        }
        sb.append(set.charAt(index));
        subSetsHelper(set, sb, result, index + 1);
        sb.deleteCharAt(sb.length() - 1);
        //如果不选当前的char eg： b， 那么把后面所有的b都略过！
        while (index < set.length() - 1 && set.charAt(index) == set.charAt(index + 1)) { //bug while not if
            index++;
        }
        subSetsHelper(set, sb, result, index + 1);
    }

    public static void main(String args[]) {
        String test = "abb";
        List<String> results = subSets(test);
        for (String result : results) {
            System.out.println(result);
        }
    }
}

/*
Given a set of characters represented by a String, return a list containing all subsets of the characters.

Assumptions

There are duplicate characters in the original set.
​Examples

Set = "abc", all the subsets are [“”, “a”, “ab”, “abc”, “ac”, “b”, “bc”, “c”]
Set = "", all the subsets are [""]
Set = null, all the subsets are []

Two bugs:
1. Forget to return at leaf level
2. remove char at length - 1
 */