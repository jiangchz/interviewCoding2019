package leetcode.string;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import static leetcode.dfs.AllPermutations1.swap;

public class MinSwapToMakePalindrome {
    public static void main(String[] args) {
        String[] input = new String[] {"mamad", "asflkj", "aabb", "ntiin"};
        for (String current : input) {
            System.out.println(getNoOfSwaps(current));
        }
    }
    public static int getNoOfSwaps(String s) {
        if (s == null || s.length() == 0 || !isSwapable(s)) {
            return -1;
        }

        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        int totalSwaps = 0;
        while (left < right) {
            if (chars[left] == chars[right]) {
                left++;
                right--;
                continue;
            }

            //search for the index of the char can pair with
            int next = right - 1;
            while (chars[next] != chars[left]) {
                next--;
            }

            //not able to found a pair
            if (next == left) {
                swap(chars, left, left + 1);
                totalSwaps++;
                continue;
            } else {
                while (next < right) {
                    swap(chars, next, next + 1);
                    totalSwaps++;
                    next++;
                }
                left++;
                right--;
            }
        }

        return totalSwaps;
    }

    private static boolean isSwapable(String s) {
        int[] counter = new int[26];
        for (char c : s.toCharArray()) {
            counter[c - 'a']+= 1;
        }

        int oddChars = 0;
        for (int c : counter) {
            if (c % 2 == 1) {
                oddChars++;
            }
        }

        return oddChars <= 1;
    }


}