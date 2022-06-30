/*
 * MainClass714.java
 * Copyright (C) 2022 2022-02-03 19:34 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
//和123题几乎一样

//请直接看这个题解 通俗易懂 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/solution/jian-dan-dpmiao-dong-gu-piao-mai-mai-by-tejdo/

//dp[i][0]表示第i天不持有可获得的最大利润
//dp[i][1]表示第i天持有可获得的最大利润（注意是第i天持有，而不是第i天买入）
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee); 
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }
}


