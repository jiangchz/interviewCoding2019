package leetcode.dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FactorCombinations {
    public List<List<Integer>> combinations(int target) {
        if (target <= 1) {
            return new ArrayList<>();
        }
        List<Integer> candidates = new ArrayList<>();
        for (int i = target - 1; i > 1; i--) {
            if (target % i == 0) {
                candidates.add(i);
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        dfs(0, path, result, candidates, target);
        return result;
    }

    private void dfs(int index, LinkedList<Integer> path, List<List<Integer>> result, List<Integer> nums, int target) {
        if (target == 1) {
            result.add(new LinkedList<>(path));
            return;
        }

        if (index == nums.size()) {
            return;
        }

        //Check the case of using 0 current number
        int currentNum = nums.get(index);
        dfs(index + 1, path, result, nums, target);

        //Check the case of using 1, 2, 3, ... n  current number
        while (target % currentNum == 0) {
            path.addFirst(currentNum);
            target /= currentNum;
            dfs(index + 1, path, result, nums, target);
        }

        while(!path.isEmpty() && path.getFirst() == currentNum) {
            path.removeFirst();
        }
    }
}


/**
 * Given an integer number, return all possible combinations of the factors that can multiply to the target number.
 *
 * Example
 *
 * Give A = 24
 *
 * since 24 = 2 x 2 x 2 x 3
 *
 *               = 2 x 2 x 6
 *
 *               = 2 x 3 x 4
 *
 *               = 2 x 12
 *
 *               = 3 x 8
 *
 *               = 4 x 6
 *
 * your solution should return
 *
 * { { 2, 2, 2, 3 }, { 2, 2, 6 }, { 2, 3, 4 }, { 2, 12 }, { 3, 8 }, { 4, 6 } }
 *
 * note: duplicate combination is not allowed.
 */