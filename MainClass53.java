/*
 * MainClass53.java
 * Copyright (C) 2022 2022-01-27 19:37 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
//请看完暴力后直接看写法二的代码和注释
//方法一 暴力破解
class Solution
{
public:
    int maxSubArray(vector<int> &nums)
    {
        //类似寻找最大最小值的题目，初始值一定要定义成理论上的最小最大值
        int max = INT_MIN;
        int numsSize = int(nums.size());
        for (int i = 0; i < numsSize; i++)
        {
            int sum = 0;
            for (int j = i; j < numsSize; j++)
            {
                sum += nums[j];
                if (sum > max)
                {
                    max = sum;
                }
            }
        }

        return max;
    }
};

//kalipy一次过 送分题 推荐
class Solution {
    public int maxSubArray(int[] nums) {
        int dp[] = new int[nums.length];
        int ans = nums[0];

        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }
}

//方法二 官方题解 动态规划优化
class Solution {
    public int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }
}


//kalipy一次过 送分题
class Solution {
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int dp[] = new int[nums.length + 1];
        
        for (int i = 1; i <= nums.length; i++) {
            dp[i] = Math.max(nums[i-1], dp[i-1] + nums[i-1]);
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }
}

