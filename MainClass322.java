/*
 * MainClass322.java
 * Copyright (C) 2022 2022-03-11 21:02 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */

//kalipy dfs超时版
class Solution {
    int cnt = 0;
    int ans = Integer.MAX_VALUE;
    int visited[];

    public int coinChange(int[] coins, int amount) {

        dfs(coins, 0, amount, 0);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private void dfs(int[] coins, int cnt, int amount, int idx) {
        if (amount == 0) {
            ans = Math.min(ans, cnt);
        }

        for (int i = idx; i < coins.length; i++) {
            if (amount < 0) return;
            dfs(coins, cnt + 1,amount - coins[i], idx);
        }
    }
}

//记忆化dfs
//链接：https://leetcode-cn.com/problems/coin-change/solution/javadi-gui-ji-yi-hua-sou-suo-dong-tai-gui-hua-by-s/
class Solution {
    int[] memo;
    public int coinChange(int[] coins, int amount) {
        if(coins.length == 0){
            return -1;
        }
        memo = new int[amount];

        return findWay(coins,amount);
    }
    // memo[n] 表示钱币n可以被换取的最少的硬币数，不能换取就为-1
    // findWay函数的目的是为了找到 amount数量的零钱可以兑换的最少硬币数量，返回其值int
    public int findWay(int[] coins,int amount){
        if(amount < 0){
            return -1;
        }
        if(amount == 0){
            return 0;
        }
        // 记忆化的处理，memo[n]用赋予了值，就不用继续下面的循环
        // 直接的返回memo[n] 的最优值
        if(memo[amount-1] != 0){
            return memo[amount-1];
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0;i < coins.length;i++){
            int res = findWay(coins,amount-coins[i]);
            if(res >= 0 && res < min){
                min = res + 1; // 加1，是为了加上得到res结果的那个步骤中，兑换的一个硬币
            }
        }
        memo[amount-1] = (min == Integer.MAX_VALUE ? -1 : min);
        return memo[amount-1];
    }
}

//kalipy一次过 推荐
public class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE / 2);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE/2 ? -1 : dp[amount];
    }
}
