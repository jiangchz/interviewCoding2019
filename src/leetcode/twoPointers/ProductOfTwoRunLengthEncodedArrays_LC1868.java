package leetcode.twoPointers;

import java.util.LinkedList;
import java.util.List;

public class ProductOfTwoRunLengthEncodedArrays_LC1868 {
    public List<List<Integer>> findRLEArray(int[][] encoded1, int[][] encoded2) {
        int p1 = 0;
        int p2 = 0;

        LinkedList<List<Integer>> result = new LinkedList<>();

        while (p1 < encoded1.length) {
            int[] first = encoded1[p1];
            int[] second = encoded2[p2];

            int common = Math.min(first[1], second[1]);
            int mult = first[0] * second[0];
            
            if (result.size() > 0 && result.getLast().get(0) == mult) {
                List<Integer> exisitingLast = result.getLast();
                int lastCount = exisitingLast.get(1);
                result.removeLast();
                result.addLast(List.of(exisitingLast.get(0), lastCount + common));
            } else {
                List<Integer> current = List.of(mult, common);
                result.addLast(current);
            }

            first[1] -= common;
            second[1] -= common;

            if (first[1] == 0) {
                p1++;
            }

            if (second[1] == 0) {
                p2++;
            }
        }
        return result;
    }
}
