/*
 * MainClass371.java
 * Copyright (C) 2022 2022-02-03 10:17 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */

//请看题解
//链接：https://leetcode-cn.com/problems/sum-of-two-integers/solution/liang-zheng-shu-zhi-he-wei-yun-suan-qing-7095/
class Solution {
    public int getSum(int a, int b) {
       if(a == 0) return b;
       int sum = a ^ b , carry = (a & b) << 1;
       return getSum(carry, sum);
    }
}


