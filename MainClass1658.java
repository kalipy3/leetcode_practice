/*
 * MainClass1658.java
 * Copyright (C) 2022 2022-02-17 16:27 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
将问题转化为求和为sum(nums)-x的最长连续子数组的长度，双指针模板题。

class Solution {
    public int minOperations(int[] nums, int x) {
        // 使用滑动窗口找中间最长的片段使得sum(片段)=sum(nums)-x
        int maxPart = -1;
        int sum = Arrays.stream(nums).sum();
        int currentSum = 0;
        int left = 0;
        int right = 0;
        while (left < nums.length) {
            // 如果右边未到尽头，不断先向右探测片段，如果大于目标sum-x则左边移动直到结束
            if (right < nums.length) {
                currentSum += nums[right++];
            }
            while (currentSum > sum - x && left < nums.length) {
                currentSum -= nums[left++];
            }
            if (currentSum == sum - x) {
                maxPart = Math.max(maxPart, right - left);
            }
            if (right == nums.length) {
                left++;
            }
        }
        return maxPart == -1 ? -1 : nums.length - maxPart;
    }
}

