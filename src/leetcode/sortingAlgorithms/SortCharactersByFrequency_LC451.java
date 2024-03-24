package leetcode.sortingAlgorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortCharactersByFrequency_LC451 {
    public String frequencySort(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();

        //frequency map
        for (char c : chars) {
            int count = map.getOrDefault(c, 0);
            map.put(c, count + 1);
        }

        //build bucket
        List<Character>[] buckets = new List[s.length() + 1];
        for (Map.Entry<Character, Integer> item : map.entrySet()) {
            char c = item.getKey();
            int freq = item.getValue();
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<Character>();
            }
            buckets[freq].add(c);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = buckets.length - 1; i >= 0; i--) {
            if (buckets[i] == null) {
                continue;
            }
            for (char c : buckets[i]) {
                sb.append(String.valueOf(c).repeat(i)) ;
            }
        }
        return sb.toString();
    }
}
