/*
 * MainClass645.java
 * Copyright (C) 2022 2022-01-30 16:32 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
//请直接看注释和代码 简单易懂

//方法一 
class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int[] cnts = new int[n + 1];
        for (int x : nums) cnts[x]++;
        int[] ans = new int[2];
        for (int i = 1; i <= n; i++) {
            if (cnts[i] == 0) ans[1] = i;
            if (cnts[i] == 2) ans[0] = i;
        }
        return ans;
    }
}

//方法二
//桶排序
//因为值的范围在 [1,n]，我们可以运用「桶排序」的思路，根据 nums[i]=i+1 的对应关系使用 O(n) 的复杂度将每个数放在其应该落在的位置里。
//然后线性扫描一遍排好序的数组，找到不符合 nums[i]=i+1对应关系的位置，从而确定重复元素和缺失元素是哪个值。
class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        int a = -1, b = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                a = nums[i];
                b = i == 0 ? 1 : nums[i - 1] + 1;
            }
        }
        return new int[]{a, b};
    }
    void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}


