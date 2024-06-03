package leetcode.string;

import java.util.*;

public class MinimumStickersRequired2_Meta {
    /**
     * it's a nature fit for using BFS to find minimal step to do something
     *
     * bitmask way: https://leetcode.com/problems/stickers-to-spell-word/solutions/108333/rewrite-of-contest-winner-s-solution/
     */


    public int minStickers(String[] stickers, String target) {
        //sort stickers and targets from A TO Z
        int len = stickers.length;
        target = sortChars(target);
        for (int i = 0; i < len; i++) {
            stickers[i] = sortChars(stickers[i]);
        }

        //BFS search original string and filtered String
        Set<String> visited = new HashSet<>();
        Queue<String> toVisit = new LinkedList<>();
        toVisit.offer(target);
        visited.add(target);
        int steps = 0;

        while(!toVisit.isEmpty()) {
            steps++;
            int size = toVisit.size();
            while(size-- > 0) {
                String current = toVisit.poll();
                for (int i = 0; i < len; i++) {
                    String unMatchedChars = filterMatchedChars(current, stickers[i]);
                    if (unMatchedChars.isEmpty()) {
                        return steps;
                    }
                    if (!visited.contains(unMatchedChars)) {
                        visited.add(unMatchedChars);
                        toVisit.offer(unMatchedChars);
                    }
                }
            }
        }
        return -1;
    }

    public String filterMatchedChars(String target, String sticker) {
        StringBuilder sb = new StringBuilder();
        int index = 0;

        for (char c : target.toCharArray()) {
            boolean found = false;
            while (index < sticker.length() && sticker.charAt(index) <= c) {
                if (sticker.charAt(index++) == c) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private String sortChars(String input) {
        char[] chars = input.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}

/**
 * Problem Description:
 * Given a string sticker that represents the set of characters available on a single sticker and a string word that represents the target word to spell out, return the minimum number of stickers that you need to spell out word. Each sticker can be used more than once, and you have an unlimited supply of stickers.
 * Meta version of https://leetcode.com/problems/stickers-to-spell-word/description/
 *
 * If the word cannot be spelled out using the letters on the sticker, return -1.
 *
 * Note:
 *
 * The sticker and word consist of lowercase English letters only.
 * The lengths of the sticker and word strings are both in the range [1, 1000].
 * Function Signature:
 *
 * public int minStickers(String sticker, String word) {
 * }
 * Example 1:
 * Input: sticker = "ban", word = "banana"
 * Output: 3
 * Explanation: We can use 3 stickers "bana" to spell out the word "banana". Each sticker provides one "b", one "a", and one "n". Three stickers provide all the letters needed to spell out "banana".
 *
 * Example 2:
 * Input: sticker = "abc", word = "def"
 * Output: -1
 * Explanation: The sticker does not contain any of the letters needed to spell out "def". Therefore, it is impossible to spell out the word.
 *
 * Constraints:
 * 1 <= sticker.length, word.length <= 1000
 * sticker and word consist of lowercase English letters.
 */
