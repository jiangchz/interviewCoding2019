package leetcode.sortingAlgorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequent_bucketSort_LC347 {
    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }


        //freq map
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        //bucketing
        List<Integer>[] buckets = new List[nums.length + 1];
        for (int key: map.keySet()){
            int frequency = map.get(key);
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(key);

        }

        //Get results
        int[] res = new int[k];
        int count = 0;
        for(int i = buckets.length - 1; i >= 0; --i){
            if(buckets[i] == null){
                continue;
            }
            for (int currentNum : buckets[i]) {
                res[count++] = currentNum;
                if (count == k) {
                    return res;
                }
            }

        }
        return res;
    }

}