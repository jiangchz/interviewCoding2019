package leetcode.dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Subsets1_LC78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> current = new LinkedList<>();
        dfs(nums, 0, res, current);
        return res;
    }

    private void dfs(int[] nums, int index, List<List<Integer>> res, LinkedList<Integer> current) {
        if (index == nums.length) {
            res.add(new LinkedList<>(current));
            return;
        }

        current.addLast(nums[index]);
        dfs(nums, index + 1, res, current);
        current.removeLast();
        dfs(nums, index + 1, res, current);
    }
}

/*
Given a set of characters represented by a String, return a list containing all subsets of the characters.

Assumptions

There are no duplicate characters in the original set.
​Examples

Set = "abc", all the subsets are [“”, “a”, “ab”, “abc”, “ac”, “b”, “bc”, “c”]
Set = "", all the subsets are [""]
Set = null, all the subsets are []

Two bugs:
1. Forget to return at leaf level
2. remove char at length - 1
 */