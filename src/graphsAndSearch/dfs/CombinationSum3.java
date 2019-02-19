package graphsAndSearch.dfs;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {
    private static final int[] candidates = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    public static void main(String args[]) {
        System.out.println(getCombinationResult(3, 9).toString());
    }

    public static List<List<Integer>> getCombinationResult(int k, int target) {
        List<Integer> currentCombination = new ArrayList<>();
        List<List<Integer>> solutionSet = new ArrayList<>();
        searchFromIndex(0, k, target, currentCombination, solutionSet);
        return solutionSet;
    }

    private static void searchFromIndex(int startIndex,
                                        int numberCount,
                                        int target,
                                        List<Integer> currentCombination,
                                        List<List<Integer>> solutionSet) {
        if (numberCount == 0 && target == 0) {
            solutionSet.add(new ArrayList<>(currentCombination));
        }

        if (numberCount == 0 || target == 0) {
            return;
        }

        for (int index = startIndex; index < 9; index++) {
            if (candidates[index] > target) {
                return;
            }

            currentCombination.add(candidates[index]);
            searchFromIndex(
                    index + 1, numberCount - 1, target - candidates[index], currentCombination, solutionSet);
            currentCombination.remove(currentCombination.size() - 1);
        }
    }
}

/*
Combination Sum 3

Find all possible combinations of k numbers that add up to a number n,
given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Example 1:

Input: k = 3, n = 7

Output:

[[1,2,4]]
Example 2:

Input: k = 3, n = 9

Output:

[[1,2,6], [1,3,5], [2,3,4]]


Summary:
Data: Feb 3rd, 2019
时间 O(N!) 空间 O(N) 递归栈空间
*/