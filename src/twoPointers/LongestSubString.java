package twoPointers;

import java.util.HashSet;

public class LongestSubString {
    public static int longest(String input) {
        if (input == null || input.length() == 0) {
            return 0;
        }

        int left = 0;
        int right = 0;
        int goblaMax = 0;
        HashSet<Character> visited = new HashSet<>();
        while (right < input.length() - 1) {
            char currentChar = input.charAt(right);
            while (visited.contains(currentChar)) {
                visited.remove(input.charAt(left++));
            }
            visited.add(currentChar);
            right++;
            goblaMax = Math.max(right - left, goblaMax);
        }
        return goblaMax;
    }
    public static void main(String args[]) {
        System.out.println(longest("bcdfbd"));
    }
}
/*
Given a string, find the longest substring without any repeating characters and return the length of it.
The input string is guaranteed to be not null.

For example, the longest substring without repeating letters for "bcdfbd" is "bcdf", we should return 4 in this case.

keyPoint: use hashset is easier than hashmap, since the key can only appear 0 or 1 time.
 */