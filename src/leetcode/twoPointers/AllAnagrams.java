package leetcode.twoPointers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AllAnagrams {
    public static List<Integer> allAnagrams(String sh, String lo) {
        List<Integer> result = new ArrayList<>();
        if (sh == null || lo == null || sh.length() == 0 || lo.length() == 0) return result;
        HashMap<Character, Integer> occurs = preprocessingLoString(lo);
        scanSourceStringForAnagrams(sh, occurs, result, lo.length());
        return result;
    }
    private static void scanSourceStringForAnagrams(String source, HashMap<Character, Integer> occurs, List<Integer> result, int loSize) {
        int uniqueLetters = occurs.size();
        int matches = 0;

        for (int i = 0; i < source.length(); i++) {
            char currentChar = source.charAt(i);
            Integer currentOccur = occurs.get(currentChar);
            if (currentOccur != null) {
                occurs.put(currentChar, ++currentOccur);
                if (currentOccur == 0) {
                    matches++;
                }
            }

            if (i >= loSize && occurs.containsKey(source.charAt(i - loSize))) {
                currentChar = source.charAt(i - loSize);
                currentOccur = occurs.get(currentChar);
                occurs.put(currentChar, --currentOccur);
                if (currentOccur == -1) {
                    matches--;
                }
            }

            if (i >= loSize - 1 && matches == uniqueLetters) {
                result.add(i - loSize + 1);
            }
        }
    }

    private static HashMap<Character, Integer> preprocessingLoString(String lo) {
        HashMap<Character, Integer> occurs = new HashMap<>();
        for (int index = 0; index < lo.length(); index++) {
            char currentChar = lo.charAt(index);
            if (!occurs.containsKey(currentChar)) {
                occurs.put(currentChar, -1);
            } else {
                occurs.put(currentChar, occurs.get(currentChar) - 1);
            }
        }
        return occurs;
    }
    public static void main(String args[]) {
        for (int i : allAnagrams("ababacbbaac", "aab")) {
            System.out.println(i);
        }



    }
}
