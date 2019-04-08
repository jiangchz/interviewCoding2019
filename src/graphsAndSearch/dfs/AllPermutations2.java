package graphsAndSearch.dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


public class AllPermutations2 {
    public static List<String> allPermutations(String input) {
        List<String> results = new ArrayList<>();
        char[] inputChars = input.toCharArray();
        dfs(inputChars, 0, results);
        return results;
    }

    private static void dfs(char[] input, int parentIndex, List<String> results) {
        if (parentIndex == input.length) {
            results.add(new String(input));
        }

        HashSet<Character> visited = new HashSet<>();
        for (int currentIndex = parentIndex; currentIndex < input.length; currentIndex++) {
            if (!visited.add(input[currentIndex])) {
                continue;
            }
            swap(input, currentIndex, parentIndex);
            dfs(input, currentIndex + 1, results);
            swap(input, currentIndex, parentIndex);
        }
    }

    public static void swap(char[] array, int index1, int index2) {
        char tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }

    public static void main(String args[]) {
        List<String> results = allPermutations("abcc");
        for (String result : results) {
            System.out.println(result);
        }
    }
}

/*
Given a string with possible duplicate characters, return a list with all permutations of the characters.

Examples

Set = “abc”, all permutations are [“abc”, “acb”, “bac”, “bca”, “cab”, “cba”]
Set = "aba", all permutations are ["aab", "aba", "baa"]
Set = "", all permutations are [""]
Set = null, all permutations are []

 */