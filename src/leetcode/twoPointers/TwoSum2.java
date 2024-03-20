package leetcode.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum2 {
    //two pointers
    public List<List<Integer>> allPairs1(int[] array, int target) {
        Arrays.sort(array);
        List<List<Integer>> result = new ArrayList<>();
        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            //trick
            if (left > 0 && array[left] == array[left - 1]) {
                left++;
                continue;
            }

            if (array[left] + array[right] > target) {
                right--;
            } else if (array[left] + array[right] < target) {
                left++;
            } else {
                result.add(Arrays.asList(array[left], array[right]));
                left++;
                right--;
            }
        }
        return result;
    }
    //HashMap
    public List<List<Integer>> allPairs2(int[] array, int target) {
        Map<Integer, Integer> numberCounter = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            Integer count = numberCounter.get(array[i]);
            //handing result
            if (count != null && count == 1 && array[i] * 2 == target) {
                result.add(Arrays.asList(array[i], array[i]));
            } else if (numberCounter.containsKey(target - array[i])&& count == null) {
                result.add(Arrays.asList(target - array[i], array[i]));
            }
            //handing counterMap. Key: separation of concern
            if (count == null) {
                numberCounter.put(array[i], 1);
            } else {
                numberCounter.put(array[i], count + 1);
            }
        }
        return result;
    }

}
