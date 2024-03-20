package leetcode.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combinationSum1to3 {
    //1
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        if (candidates == null || candidates.length == 0|| target < 0) {
            return results;
        }
        List<Integer> result = new ArrayList<>();
        Arrays.sort(candidates);//bug2
        combinationSumHelper1(results, result, candidates, target, 0);
        return results;
    }

    private void combinationSumHelper1(List<List<Integer>> results,
                                      List<Integer> result,
                                      int[] candidates,
                                      int target,
                                      int startIndex) {
        if (target == 0) {
            results.add(new ArrayList<Integer>(result));//bug1
            return;//bug
        }

        for (int i = startIndex; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                break;
            }
            result.add(candidates[i]);
            combinationSumHelper1(results, result, candidates, target - candidates[i], i);
            result.remove(result.size() - 1);
        }
    }

    //2
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        if (candidates == null || candidates.length == 0|| target < 0) {
            return results;
        }
        List<Integer> result = new ArrayList<>();
        Arrays.sort(candidates);//bug2
        combinationSumHelper2(results, result, candidates, target, 0);
        return results;
    }

    private void combinationSumHelper2(List<List<Integer>> results,
                                      List<Integer> result,
                                      int[] candidates,
                                      int target,
                                      int startIndex) {
        if (target == 0) {
            results.add(new ArrayList<Integer>(result));//bug1
            return;//bug
        }

        for (int i = startIndex; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                break;
            }
            //wrong version
            //while (i!= 0 && candidates[i - 1] == candidates[i]) {i++;}
            if (i != startIndex && candidates[i - 1] == candidates[i]) {//bug
                continue;
            }
            result.add(candidates[i]);
            combinationSumHelper2(results, result, candidates, target - candidates[i], i + 1);
            result.remove(result.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> results = new ArrayList<>();
        if (k <= 0 || n <= 0) {
            return results;
        }
        List<Integer> result = new ArrayList<>();
        combinationSumHelper3(results, result, n, 1, k);
        return results;
    }

    private void combinationSumHelper3(List<List<Integer>> results,
                                       List<Integer> result,
                                       int target,
                                       int startIndex,
                                       int k) {
        if (result.size() > k || target < 0) {
            return;
        }
        if (target == 0 && result.size() == k) {
            results.add(new ArrayList<Integer>(result));//bug1
            return;
        }

        for (int i = startIndex; i < 10; i++) {
            result.add(i);
            combinationSumHelper3(results, result, target - i, i + 1, k);
            result.remove(result.size() - 1);
        }
    }



}
