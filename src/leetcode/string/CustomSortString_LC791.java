package leetcode.string;

import java.util.HashMap;
import java.util.Map;

public class CustomSortString_LC791 {
    public String customSortString(String order, String s) {
        //build freqMap for the source string
        Map<Character, Integer> sFreqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            sFreqMap.put(c, sFreqMap.getOrDefault(c, 0) + 1);
        }

        //append existing letters to res
        StringBuilder res = new StringBuilder();
        for (char c : order.toCharArray()) {
            if (sFreqMap.containsKey(c)) {
                int freq = sFreqMap.get(c);
                while (freq-- > 0) {
                    res.append(c);
                }
                sFreqMap.remove(c);
            }
        }

        //apend unmatched letters
        for (char c : s.toCharArray()) {
            if (sFreqMap.containsKey(c)) {
                res.append(c);
            }
        }

        return res.toString();
    }
}
