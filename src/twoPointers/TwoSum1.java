package twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum1 {
    public List<List<Integer>> allPairs(int[] array, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> numsToIndexs = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            List<Integer> firstIndexList = numsToIndexs.get(target - array[i]);
            if (firstIndexList != null) {
                for (int firstIndex : firstIndexList){
                    result.add(Arrays.asList(firstIndex, i));
                }
            }

            if (numsToIndexs.containsKey(array[i])) {
                numsToIndexs.get(array[i]).add(i);
            } else {
                numsToIndexs.put(array[i], new ArrayList<>(Arrays.asList(i)));
            }
        }
        return result;
    }


    public static void main(String args[]) {
        int[]  test = new int[] {1, 3, 3, 4, 5, 2 , 2,1, 3,1};
        int target = 4;
        TwoSum1 twoSum1 = new TwoSum1();
        twoSum1.allPairs(test, target);
    }
}

/*
Find all pairs of elements in a given array that sum to the given target number. Return all the pairs of indices.

Assumptions

The given array is not null and has length of at least 2.

Examples

A = {1, 3, 2, 4}, target = 5, return [[0, 3], [1, 2]]

A = {1, 2, 2, 4}, target = 6, return [[1, 3], [2, 3]]


 */