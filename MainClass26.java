/*
 * MainClass26.java
 * Copyright (C) 2022 2022-01-31 11:28 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
//值得多做几遍 易错
class Solution {
    public int removeDuplicates(int[] nums) {

        int l = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[l] != nums[i]) {
                l++;
                nums[l] = nums[i];

            }
        }

        //return (l++);//error
        return ++l;//ok
    }
}
