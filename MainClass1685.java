/*
 * MainClass1685.java
 * Copyright (C) 2022 2022-03-17 14:32 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
//kalipy 暴力破解 超时 不推荐
class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int ans[] = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                ans[i] += Math.abs(nums[i] - nums[j]);
            }
        }

        return ans;
    }
}


