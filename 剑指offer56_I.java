/*
 * 剑指offer56_I.java
 * Copyright (C) 2022 2022-02-17 22:28 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */

//送分题 请直接看注释和代码
//相同的数异或为0，不同的异或为1。0和任何数异或等于这个数本身。
//
//所以，数组里面所有数异或 = 目标两个数异或 。 由于这两个数不同，所以异或结果必然不为0。
//
//假设数组异或的二进制结果为10010，那么说明这两个数从右向左数第2位是不同的
//
//那么可以根据数组里面所有数的第二位为0或者1将数组划分为2个。
//
//这样做可以将目标数必然分散在不同的数组中，而且相同的数必然落在同一个数组中。
//
//这两个数组里面的数各自进行异或，得到的结果就是答案
class Solution {
    public int[] singleNumbers(int[] nums) {
        int ret = 0;
        for (int n : nums) {
            ret ^= n;
        }
        int div = 1;
        while ((div & ret) == 0) {
            div <<= 1;
        }
        int a = 0, b = 0;
        for (int n : nums) {
            if ((div & n) != 0) {
                a ^= n;
            } else {
                b ^= n;
            }
        }
        return new int[]{a, b};
    }
}

