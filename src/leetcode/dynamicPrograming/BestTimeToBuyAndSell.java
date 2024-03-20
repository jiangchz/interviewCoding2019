package leetcode.dynamicPrograming;

public class BestTimeToBuyAndSell {
    //version 0
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int minBuy = prices[0];
        int maxSell = 0;
        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (minBuy > prices[i]) {
                minBuy = prices[i];
                maxSell = prices[i + 1];
            } else {
                maxSell = Math.max(maxSell, prices[i + 1]);
            }
            maxProfit = Math.max(maxSell - minBuy, maxProfit);
        }
        return maxProfit;
    }
    //version1
    //其实不用存maxSell 变量，在一维数组扫一遍的时候，不断的去更新maxProfit的值就好了。
    // 分析清楚物理意义，最高的卖价的点只能是在更新了最低买价以后出现，所以不用记录gobal的最高卖价
    public int maxProfit1(int[] prices) {
                 if (prices == null || prices.length == 0) {
                        return 0;
                    }
                 int m = prices.length;
                 int max = 0;
                 int min = prices[0];
                 for (int i = 1; i < m; i++) {
                         min = Math.min(min, prices[i]);
                         max = Math.max(max, prices[i] - min);
                     }
                 return max;
             }
}
