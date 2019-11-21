package dfs;

import java.util.ArrayList;
import java.util.List;


public class AllPermutations1 {
    public static List<String> allPermutations(String input) {
        List<String> results = new ArrayList<>();
        dfs(input.toCharArray(), 0, results);
        return results;
    }

    private static void dfs(char[] input, int index, List<String> results) {
        if (index == input.length) {
            results.add(new String(input));
            return;
        }

        /*
        每层recursion的物理意义是： 把某个字母放在position 。
        recursion 负责跳到下一个position
        for 循环用于寻找放在该层位置的字母
         */
        for (int i = index; i < input.length; i++) {
            swap(input, i, index);
            dfs(input, index + 1, results);
            swap(input, i, index);
        }
    }

    public static void swap(char[] array, int index1, int index2) {
        char tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }

    public static void main(String args[]) {
        List<String> results = allPermutations("abc");
        for (String result : results) {
            System.out.println(result);
        }
    }
}

/*
Given a string with no duplicate characters, return a list with all permutations of the characters.

Examples

Set = “abc”, all permutations are [“abc”, “acb”, “bac”, “bca”, “cab”, “cba”]
Set = "", all permutations are [""]
Set = null, all permutations are []

 */