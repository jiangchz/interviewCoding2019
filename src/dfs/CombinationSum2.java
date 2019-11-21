package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    public static void main(String args[]) {
        int[] candidates = new int[]{10, 1, 1 ,1, 1, 2, 2, 7, 6, 1, 5};
        System.out.println(getCombinationResult(candidates, 10).toString());
    }

    public static List<List<Integer>> getCombinationResult(final int[] candidates, int target) {
        int[] sortedCandidates = Arrays.copyOf(candidates, candidates.length);
        Arrays.sort(sortedCandidates);
        List<Integer> currentCombination = new ArrayList<>();
        List<List<Integer>> solutionSet = new ArrayList<>();
        searchFromIndex(sortedCandidates, 0, target, solutionSet, currentCombination);
        return solutionSet;
    }

    private static void searchFromIndex(final int[] candidates,
                                        int startIndex,
                                        int target,
                                        List<List<Integer>> solutionSet,
                                        List<Integer> currentCombination) {
        if (target == 0) {
            solutionSet.add(new ArrayList<>(currentCombination));
        }

        for (int index = startIndex; index < candidates.length; index++) {
            if (index != startIndex && candidates[index] == candidates[index - 1]) {
                continue;
            }

            if (candidates[index] > target) {
                break;
            }

            currentCombination.add(candidates[index]);
            searchFromIndex(
                    candidates, index + 1, target - candidates[index], solutionSet, currentCombination);
            currentCombination.remove(currentCombination.size() - 1);
        }
    }
}

/*
Combination Sum 2

Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.


For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
A solution set is:

[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]

Summary:
Data: Feb 3rd, 2019
时间 O(N!) 空间 O(N) 递归栈空间
*/