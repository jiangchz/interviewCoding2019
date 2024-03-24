package leetcode.twoPointers;

import java.util.ArrayList;
import java.util.List;

public class DotProduct_lc1570 {
    private static class SparseVector {
        List<int[]> pairs;


        SparseVector(int[] nums) {
            pairs = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    pairs.add(new int[]{i, nums[i]});
                }
            }

        }

        // Return the dotProduct of two sparse vectors
        public int dotProduct(SparseVector vec) {
            int result = 0;
            int i = 0;
            int j = 0;
            List<int[]> inputPairs = vec.pairs;
            while (i < pairs.size() && j < inputPairs.size()) {
                if (pairs.get(i)[0] == inputPairs.get(j)[0]) {
                    result += pairs.get(i++)[1] * inputPairs.get(j++)[1];
                } else if (pairs.get(i)[0] > inputPairs.get(j)[0]) {
                    j++;
                } else {
                    i++;
                }
            }
            return result;
        }
    }
}
