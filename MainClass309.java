/*
 * MainClass309.java
 * Copyright (C) 2022 2022-02-03 19:36 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
//官方题解
//请直接看代码
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // dp[i][0]: 手上持有股票的最大收益
        // dp[i][1]: 手上不持有股票，并且处于冷冻期中的累计最大收益
        // dp[i][2]: 手上不持有股票，并且不在冷冻期中的累计最大收益
        int[][] dp = new int[n][3];
        dp[0][0] = -prices[0];
        for (int i = 1; i < n; ++i) {
            //当前持有股票(前一天就是这状态、今天刚买入(只有非冷冻期才可买入))
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            //当前为冷冻期没有股票(前一天卖股票了(拥有状态才可卖))
            //注意有股票不可能处于冷冻期
            dp[i][1] = dp[i - 1][0] + prices[i];
            //当前为非冷冻期没有有股票(前一天是冷冻期没有股票,前一天就是这状态)
            //今天不能卖出股票，不然今天卖出后就成dp[i][1]冷冻期了 ;所以不能dp[i - 1][0] + prices[i]
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
        }
        return Math.max(dp[n - 1][1], dp[n - 1][2]);
    }
}
