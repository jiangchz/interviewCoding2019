package leetcode.dynamicPrograming;

public class BestTimetoBuyAndSell3 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        if (prices.length <= 4) {
            int max = 0;
            for (int i = 1; i < prices.length; i++) {
                max += (prices[i] > prices[i - 1]) ? (prices[i] - prices[i - 1]) : 0;
            }
            return max;
        }

        int[] leftToRight = new int[prices.length];//the max profix for 1 transaction in 0 - i
        int[] rightToLeft = new int[prices.length];//the max profix for 1 transaction in i - (length-1)

        //left to right scan to find max profit
        int minBuy = prices[0];
        leftToRight[0] = 0;
        for (int i = 1; i < prices.length - 1; i++) {
            minBuy = prices[i - 1] < minBuy ? prices[i - 1] : minBuy;
            leftToRight[i] = Math.max(prices[i] - minBuy, leftToRight[i - 1]);
        }

        //right to left scan for max profit
        int maxSell = prices[prices.length - 1];
        rightToLeft[prices.length - 1] = 0;
        for (int i = prices.length - 2; i > 0; i--) {
            maxSell = prices[i + 1] > maxSell ? prices[i + 1] : maxSell;
            rightToLeft[i] = Math.max(maxSell - prices[i], rightToLeft[i + 1]);
        }

        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            max = Math.max(max, leftToRight[i] + rightToLeft[i]);
        }
        return max;
    }
}
