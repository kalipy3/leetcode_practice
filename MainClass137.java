/*
 * MainClass137.java
 * Copyright (C) 2022 2022-01-30 14:56 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
//链接：https://leetcode-cn.com/problems/single-number-ii/solution/single-number-ii-mo-ni-san-jin-zhi-fa-by-jin407891/
//方法二 推荐 请直接看题解和代码 通俗易懂
class Solution {
    public int singleNumber(int[] nums) {
        int[] counts = new int[32];
        for(int num : nums) {
            for(int j = 0; j < 32; j++) {
                counts[j] += num & 1;
                num >>>= 1;
            }
        }
        int res = 0, m = 3;
        for(int i = 0; i < 32; i++) {
            res <<= 1;
            res |= counts[31 - i] % m;
        }
        return res;
    }
}

//kalipy一次过
class Solution {
    public int singleNumber(int[] nums) {
        int cnt[] = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                cnt[i] += num & 1;
                num >>>= 1;
            }
        }

        int ans = 0;
        for (int i = 31; i >=0; i--) {
            ans <<= 1;//这句话必须在前面
            ans |= (cnt[i] % 3);
        }

        return ans;
    }
}
