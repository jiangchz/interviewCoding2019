package leetcode.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
    //swap version1
    public List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        Integer[] integers = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            integers[i] = nums[i];
        }

        permutationHelper(integers, 0, result);
        return result;
    }
    private void permutationHelper(Integer[] integers, int startIndex, List<List<Integer>> result) {
        if (startIndex == integers.length) {
            result.add(new ArrayList<>(Arrays.asList(integers)));
            return;
        }
        for (int i = startIndex; i < integers.length; i++) {
            swap(integers, i , startIndex);
            permutationHelper(integers, startIndex + 1, result);
            swap(integers, i , startIndex);
        }
    }
    private void swap(Integer[] integers, int index1, int index2) {
        int tmp = integers[index1];
        integers[index1] = integers[index2];
        integers[index2] = tmp;
    }
}
