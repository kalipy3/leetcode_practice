/*
 * MainClass1363.java
 * Copyright (C) 2022 2022-02-10 10:48 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */

// 简单题
// 先看官方题解 再看代码
// sum % 3 = 1，如果没有=1的，那么必有两个%3=2的导致了sum%3=1，如:(2+2)%3=1
class Solution {
    private int[] cnt;
    private int sum;

    // 删除的时候，从小的开始删除，因为要求最后的数最大，所以先删较小的
    private boolean del(int num) {
        for (int i = num; i <= 9; i+=3) {
            if (cnt[i] > 0) {
                cnt[i]--;
                return true;
            }
        }
        return false;
    }

    public String largestMultipleOfThree(int[] digits) {
        if (digits == null || digits.length == 0) {
            throw new IllegalArgumentException();
        }
        this.cnt = new int[10];
        for (int digit : digits) {
            this.cnt[digit]++;
            this.sum += digit;
        }
        int remainder = this.sum % 3;
        // 如果余数为 1，尝试删除 1 个余数为 1 的数，如果所有余数为 1 的数都没有“库存”（cnt 为 0），则删除两个余数为 2 的数 
        if (remainder == 1 && !del(1)) {
            del(2);
            del(2);
        }
        // 如果余数为 2，尝试删除 1 个余数为 2 的数，如果所有余数为 2 的数都没有“库存”（cnt 为 0），则删除两个余数为 1 的数 
        if (remainder == 2 && !del(2)) {
            del(1);
            del(1);
        }

        StringBuilder res = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            while (cnt[i]-- > 0) {
                // 如果最高位为0，就不继续添加了
                if (res.length() == 1 && res.charAt(res.length() - 1) == '0') break;
                res.append(i);
            }
        }
        return res.toString();
    }
}
