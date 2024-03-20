package leetcode.twoPointers;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithAtLeaseK {
    public int longestSubstring(String s, int k) {
        int slow = 0;
        int fast = 0;
        char[] chars = s.toCharArray();
        Map<Character, Integer> counter = new HashMap<>();
        int result = 0;
        assert fast > 0;
        while (fast < chars.length) {
            while (isValid(counter, k )) {
                result = Math.max(result, fast - slow + 1);
                char c = chars[fast++];
                counter.merge(c, 1, (oldValue, newVal) -> oldValue + newVal);
            }

            while(!isValid(counter, k)) {
                char c = chars[slow++];
                counter.put(c, counter.get(c) - 1);
            }
        }
        return result;
    }

    private boolean isValid(Map<Character, Integer> counter, int k) {
        for (char c : counter.keySet()) {
            if (counter.get(c) > 0 && counter.get(c) < k) {
                return false;
            }
        }
        return true;
    }
}
