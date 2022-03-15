/*
 * MainClass674.java
 * Copyright (C) 2022 2022-02-02 21:18 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */

//方法二
class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length<1){
            return 0;
        }
        int d = 0;
        int max = 1;
        for(int i =1;i<nums.length;i++){
            if(nums[i] > nums[i-1]){
                max = Math.max(i - d + 1,max);
            }else{
                d = i;
            }
        }
        return max;
    }
}

//请直接看题解 简单
//链接：https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence/solution/tu-biao-si-lu-kan-bu-dong-ni-da-wo-ji-ba-7fr7/
class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            }
            res = Math.max(res, dp[i]);
        }   
        return res;
    }
}


//kalipy一次过
class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int[] dp = new int[nums.length];

        int ans = 1;
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i-1]) {
                dp[i] = dp[i-1] + 1;
            } else {
                dp[i] = 1;
            }
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }
}

//kalipy一次过 推荐！！比dp快很多
class Solution {
    public int findLengthOfLCIS(int[] nums) {

        int ans = 1;

        int l = 0;
        int r = 0;
        while (r < nums.length) {
            if (r >= 1 && nums[r] <= nums[r-1]) {
                l = r;
            }

            ans = Math.max(ans, r - l + 1);
            r++;
        }

        return ans;
    }
}
