/*
 * MainClass80.java
 * Copyright (C) 2022 2022-01-31 11:39 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
//请直接看代码
class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i < 2 || n > nums[i-2])
                nums[i++] = n;
        return i;
    }
}

//写法二
class Solution {
    public int removeDuplicates(int[] nums) {
        
        int idx = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] > nums[idx-2]) {
                nums[idx++] = nums[i];
            }
        }
        return idx;
    }
}
