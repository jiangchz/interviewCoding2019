package leetcode.dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationsOfCoins {
    public static List<List<Integer>> combinations(int target, int[] coins) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(target, new LinkedList<>(), result, coins, 0);
        return result;
    }

    private static void dfs(int remains, LinkedList<Integer> path, List<List<Integer>> result, int[] coins, int index) {
        if (remains == 0 && index == coins.length) {
            result.add(new LinkedList<>(path));
            return;
        }

        if (remains < 0 || index == coins.length) {
            return;
        }

        for (int count = 0; remains - coins[index] * count >= 0; count++) {
            path.add(count);
            dfs(remains - coins[index] * count, path, result, coins, index + 1);
            path.removeLast();
        }
    }

    public static void main(String args[]) {
        List<List<Integer>> results = combinations(10, new int[]{34,31,29,16,2});
        for (List<Integer> result: results) {
            for (int num : result) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

/*
Given a number of different denominations of coins (e.g., 1 cent, 5 cents, 10 cents, 25 cents), get all the possible ways to pay a target number of cents.

Arguments

coins - an leetcode.array of positive integers representing the different denominations of coins, there are no duplicate numbers and the numbers are sorted by descending order, eg. {25, 10, 5, 2, 1}
target - a non-negative integer representing the target number of cents, eg. 99
Assumptions

coins is not null and is not empty, all the numbers in coins are positive
target >= 0
You have infinite number of coins for each of the denominations, you can pick any number of the coins.
Return

a list of ways of combinations of coins to sum up to be target.
each way of combinations is represented by list of integer, the number at each index means the number of coins used for the denomination at corresponding index.
Examples

coins = {2, 1}, target = 4, the return should be

[

  [0, 4],   (4 cents can be conducted by 0 * 2 cents + 4 * 1 cents)

  [1, 2],   (4 cents can be conducted by 1 * 2 cents + 2 * 1 cents)

  [2, 0]    (4 cents can be conducted by 2 * 2 cents + 0 * 1 cents)

]
 */