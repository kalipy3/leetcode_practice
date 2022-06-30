/*
 * MainClass518.java
 * Copyright (C) 2022 2022-01-29 10:46 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */

//请先看官方题解 推荐
class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}



//方法一 直接把39题代码复制过来，调用 超时
class Solution {
    int ans = 0;
    public int change(int amount, int[] coins) {

        combinationSum(coins, amount);

        return ans;
    }

    public void combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates); // 先进行排序
        backtracking(candidates, target, 0, 0);
    }

    public void backtracking(int[] candidates, int target, int sum, int idx) {
        // 找到了数字和为 target 的组合
        if (sum == target) {
            ans++;
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            // 如果 sum + candidates[i] > target 就终止遍历
            if (sum + candidates[i] > target) break;
            backtracking(candidates, target, sum + candidates[i], i);
        }
    }
}


//方法二 记忆化dfs 只有c++才能不超时，java会超时
class Solution {
public:
    vector<vector<int>>memo;
    int change(int amount, vector<int>& coins) {
        memo.resize(coins.size(),vector<int>(amount+1,-1));
        return dfs(0,amount,coins);
    }
    int dfs(int beg,int amount,vector<int>&coins){
        if(amount==0)return 1;
        if(beg==coins.size()||amount<0)return 0;
        if(memo[beg][amount]!=-1)return memo[beg][amount];
        int ans=0;
        for(int i=beg;i<coins.size();i++){
            ans+=dfs(i,amount-coins[i],coins);
        }
        memo[beg][amount]=ans;
        return ans;
    }
};


//kalipy一次过 推荐 送分题
class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];

        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }

        return dp[amount];
    }
}
