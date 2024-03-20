package leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

public class CombinationsOfCoins {
    public static List<List<Integer>> combinations(int target, int[] coins) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentCombination = new ArrayList<>(coins.length);
        bfs(result, currentCombination, target, coins, 0);
        return result;
    }

    private static void bfs(List<List<Integer>> result,
                            List<Integer>  currentCombination,
                            int remains,
                            int[] coins,
                            int index) {
        if (index == coins.length - 1) {//bug
            if (remains % coins[index] == 0) {//bug
                currentCombination.add(remains / coins[index]);
                result.add(new ArrayList<>(currentCombination));
                currentCombination.remove(currentCombination.size() - 1);
            }
            return; // bug2
        }

        for (int i = 0; i <= remains / coins[index]; i++) { //bug4 <=
            currentCombination.add(i);
            bfs(result, currentCombination, remains - coins[index] * i, coins, index + 1 );
            currentCombination.remove(currentCombination.size() - 1); //bug3
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