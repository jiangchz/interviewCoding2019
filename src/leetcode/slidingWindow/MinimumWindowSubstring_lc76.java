package leetcode.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring_lc76 {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        char[] source = s.toCharArray();
        Map<Character, Integer> counter = new HashMap<>();
        for (char c : t.toCharArray()) {
            counter.put(c, counter.getOrDefault(c, 0) + 1);
        }

        String result = "";
        int targetMatch = counter.size();
        int currentMatch = 0;

        for (int left = 0, right = 0; right < source.length; right++) {
            char c = source[right];
            if (!counter.containsKey(c)) {
                continue;
            }

            int letterNeeded = counter.get(c);
            counter.put(c, letterNeeded - 1);
            if (letterNeeded == 1) {
                currentMatch++;
            }

            if (targetMatch == currentMatch) {
                //if we found a valid substring, we need to shink it and update the result
                char leftChar = source[left];
                while (left < right && (!counter.containsKey(leftChar) || counter.get(leftChar) < 0)) {
                    if (counter.containsKey(leftChar)) {
                        counter.put(leftChar, counter.get(leftChar) + 1);
                    }
                    leftChar = source[++left];
                }

                //Update the result
                if (result.length() == 0 || result.length() > (right - left + 1)) {
                    result = new String(source, left, right - left + 1);
                }

                //move left to make it invalid
                counter.put(leftChar, counter.get(leftChar) + 1);
                left++;
                currentMatch--;
            }

        }
        return result;
    }
}
