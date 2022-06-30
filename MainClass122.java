/*
 * MainClass122.java
 * Copyright (C) 2022 2022-02-03 17:22 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
//算法题（×） 脑筋急转弯题( √ ）
//因为交易次数不受限，如果可以把所有的上坡全部收集到，一定是利益最大化的
//扫描一遍 只要后一天比前一天大 就把这两天的差值加一下
//送分题
class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                ans += prices[i] - prices[i - 1];
        }

        return ans;
    }
}

//方法二 kalipy一次过 送分题
class Solution {
    public int maxProfit(int[] prices) {
        int[] dp = new int[prices.length];//dp[i]：第i天卖出后，可以收获的最大利润
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                dp[i] = dp[i - 1] + (prices[i] - prices[i - 1]);
            } else
                dp[i] = dp[i - 1];

            //简化写法
            //dp[i] = Math.max(dp[i - 1] + (prices[i] - prices[i - 1]), dp[i - 1]);

            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }
}

