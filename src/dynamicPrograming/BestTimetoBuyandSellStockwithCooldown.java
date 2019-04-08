package dynamicPrograming;

public class BestTimetoBuyandSellStockwithCooldown {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2) return 0;

        int[] sell = new int[prices.length];
        int[] buy = new int[prices.length];
        sell[0] = 0;
        buy[0] = - prices[0];

        for(int i = 1; i < prices.length; i++) {
            sell[i] = Math.max(prices[i] + buy[i - 1], sell[i - 1]);
            buy[i] = Math.max(buy[i - 1], (i > 1 ? sell[i - 2] : 0 ) - prices[i]);
        }
        return sell[prices.length - 1];
    }
}
/*
1. 动态规划general的思想，后一个状态取决于前面的一个或者几个状态。这个题也不例外，但是induction rule不是特别明显。
2. 涉及到的状态太多，比如我是买还是卖，什么时候买卖，我当前的状态是否需要cool down之类的。用一个一维数组，if else的情况太多很难想清楚。
-> 关键点 a. 一个数组表示之前的状态太复杂，考虑开2个数组，分别记录买的时候的最大利润和卖的时候的最大利润。
开2个数组来存dp的状态是很多题目通用的技巧，比如一些string的题，从左往右扫一遍，然后从右往左再扫一遍。
> 关键点b. 动态规划考虑当前问题和小1号问题之间的联系。所以buy[i]取决于buy[i - 1] 和 sell[i - 2]
(因为有冷冻期)。 想清楚induction rule 当前问题和小一号问题之间的关系是整个题目的关键
 */