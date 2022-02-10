/*
 * MainClass633.java
 * Copyright (C) 2022 2022-02-09 20:57 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */

//方法0 用两数之和的哈希表思想 kalipy一次过
class Solution {
    public boolean judgeSquareSum(int c) {
        
        Set<Long> set = new HashSet<>();
        for (long i = 0; i*i <= c; i++) {
            set.add(i*i);
            if (set.contains(c-i*i)) return true;
        }

        return false;
    }
}

//方法一 枚举 链接：https://leetcode-cn.com/problems/sum-of-square-numbers/solution/gong-shui-san-xie-yi-ti-san-jie-mei-ju-s-7qi5/
class Solution {
    public boolean judgeSquareSum(int c) {
        int max = (int)Math.sqrt(c);
        for (int a = 0; a <= max; a++) {
            int b = (int)Math.sqrt(c - a * a);
            if (a * a + b * b == c) return true;
        }
        return false;
    }
}


//方法二 二分双指针 简单
class Solution {
    public boolean judgeSquareSum(int c) {
        long left = 0;
        long right = (long) Math.sqrt(c);
        while (left <= right) {
            long sum = left * left + right * right;
            if (sum == c) {
                return true;
            } else if (sum > c) {
                right--;
            } else {
                left++;
            }
        }
        return false;
    }
}

