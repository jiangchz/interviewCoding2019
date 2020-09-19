package dfs;

import java.util.ArrayList;
import java.util.List;


public class AllPermutations1 {
    public static List<String> allPermutations(String input) {
        List<String> results = new ArrayList<>();
        dfs(input.toCharArray(), 0, results);
        return results;
    }

    private static void dfs(char[] input, int indexInResultString, List<String> results) {
        if (indexInResultString == input.length) {
            results.add(new String(input));
            return;
        }

        for (int i = indexInResultString; i < input.length; i++) {
            swap(input, i, indexInResultString);
            dfs(input, indexInResultString + 1, results);
            swap(input, i, indexInResultString);
        }
    }

    public static void swap(char[] array, int index1, int index2) {
        char tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }

    public static void main(String args[]) {
        List<String> results = allPermutations("abc");
        for (String result : results) {
            System.out.println(result);
        }
    }
}

/*
题目：
    Given a string with no duplicate characters, return a list with all permutations of the characters.

    Examples

    Set = “abc”, all permutations are [“abc”, “acb”, “bac”, “bca”, “cab”, “cba”]
    Set = "", all permutations are [""]
    Set = null, all permutations are []

分析：

    每层recursion的物理意义是： 把字母放在与当前层recursion对应的position
    比如第一层recursion，就是用于填写result string的第一个字母，然后填写第二个字母的任务交给下层recursion
    终止条件：当需要填写第input.length个字母时，说明0 ～ （length -1）的字母都已经填好了
    for 循环用于不断替换放在当前recursion层对应位置的字母
时间复杂度：
    n * n!  有那个位置需要执行一次dfs，对于每一次dfs每个位置有n！种可能的排列
 */