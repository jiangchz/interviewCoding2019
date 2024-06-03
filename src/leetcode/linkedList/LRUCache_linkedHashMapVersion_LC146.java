package leetcode.linkedList;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache_linkedHashMapVersion_LC146 {
    LinkedHashMap<Integer, Integer> cache;

    public LRUCache_linkedHashMapVersion_LC146(int capacity) {
        cache = new LinkedHashMap<>(capacity, 0.75F, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return this.size() > capacity;
            }
        };
    }

    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }
}
