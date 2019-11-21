package dfs;/*
Given a set of candidate numbers (C) and a target number (T),
find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.


For example, given candidate set [2, 3, 6, 7] and target 7,
A solution set is:

[
  [7],
  [2, 2, 3]
]
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//assumption no duplicate number in candidates & candidates are sorted.
public class CombinationSum1 {
    public static void main(String args[]) {
        int[] candidates = new int[]{2, 3, 5, 6, 7};
        System.out.println(getCombinationResult(candidates, 7).toString());
    }

    public static List<List<Integer>> getCombinationResult(final int[] candidates, int target) {
        int[] sortedCandidates = Arrays.copyOf(candidates,candidates.length);
        List<Integer> currentCombination = new ArrayList<>();
        List<List<Integer>> solutionSet = new ArrayList<>();
        searchFromIndex(sortedCandidates, 0, target, solutionSet, currentCombination);
        return solutionSet;
    }

    private static void searchFromIndex(final int[] candidates,
                                        int currentIndex,
                                        int target,
                                        List<List<Integer>> solutionSet,
                                        List<Integer> currentCombination) {
        for (int index = currentIndex; index < candidates.length; index++) {
            if (candidates[index] < target) {
                currentCombination.add(candidates[index]);
                searchFromIndex(
                        candidates,
                        index,
                        target - candidates[index],
                        solutionSet,
                        currentCombination);
                currentCombination.remove(currentCombination.size() - 1);
            } else if (candidates[index] == target) {
                List<Integer> matchedCombination = new ArrayList<>(currentCombination);
                matchedCombination.add(candidates[index]);
                solutionSet.add(matchedCombination);
                return;
            } else {
                return;
            }
        }
    }
}

/*
Summary:
Data: Feb 3rd, 2019
时间 O(N!) 空间 O(N) 递归栈空间
*/