package leetcode.dfs;

import java.util.*;

public class Subset1WithSizeK_LC77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        dfs(n, k, 0, path, result);
        return result;
    }

    private void dfs(int n, int k, int index, LinkedList<Integer> path, List<List<Integer>> result) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }

        if (index == n) {
            return;
        }

        path.add(index + 1);
        dfs(n, k, index + 1, path, result);
        path.removeLast();
        dfs(n, k, index + 1, path, result);
    }
}

/**
 *Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].
 *
 * You may return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 4, k = 2
 * Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
 * Explanation: There are 4 choose 2 = 6 total combinations.
 * Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.
 * Example 2:
 *
 * Input: n = 1, k = 1
 * Output: [[1]]
 * Explanation: There is 1 choose 1 = 1 total combination.
 *
 *
 *
 *
 */
