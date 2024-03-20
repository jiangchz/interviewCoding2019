package leetcode.dynamicPrograming;

public class BestTimeToBuyAndSell4 {
    public int maxProfit(int k, int[] prices) {
        if (k == 0 || prices == null || prices.length == 0) {
        return 0;
    }

        if (k >= prices.length / 2) {
        int profit = 0;
        for (int i = 1; i <  prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += (prices[i] - prices[i - 1]);
            }
        }
        return profit;
    }
    int[][] mustSell = new int[prices.length][k + 1];
    int[][] gobalMax = new int[prices.length][k + 1];

    mustSell[0][0] = 0;
    gobalMax[0][0] = 0;

        for(int i = 1; i < prices.length; i++) {
        mustSell[i][0] = 0;
        for (int j = 1; j <= k; j++) {
            int diff = prices[i] - prices[i - 1];
            mustSell[i][j] = Math.max(mustSell[i - 1][j] + diff, gobalMax[i - 1][j - 1] + diff);
            gobalMax[i][j] = Math.max(gobalMax[i - 1][j], mustSell[i][j]);
        }
    }
        return gobalMax[prices.length - 1][k];
    }
}
