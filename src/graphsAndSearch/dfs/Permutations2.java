package graphsAndSearch.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Permutations2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Integer[] integers = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            integers[i] = nums[i];
        }
        permutationHelper(integers, result, 0);
        return result;
    }

    private void permutationHelper(Integer[] integers, List<List<Integer>> result, int startIndex) {
        if (integers.length == startIndex) {
            result.add(new ArrayList<>(Arrays.asList(integers)));
        }

        HashSet<Integer> visited = new HashSet<>();
        /* wrong version, because after swap, the order of nums will not remain sorted
            for (int i = startIndex; i < integers.length; i++) {
                if (i != startIndex && integers[i] == integers[i - 1]) {
                    continue;
            }
         */
        for (int i = startIndex; i < integers.length; i++) {
            if (!visited.add(integers[i])) {
                continue;
            }
            swap(integers, startIndex, i);
            permutationHelper(integers, result, startIndex + 1);
            swap(integers, startIndex, i);
        }
    }

    private void swap(Integer[] integers, int index1, int index2) {
        int tmp = integers[index1];
        integers[index1] = integers[index2];
        integers[index2] = tmp;
    }
}
