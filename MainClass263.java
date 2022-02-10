/*
 * MainClass263.java
 * Copyright (C) 2022 2022-02-09 11:14 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */

//官方题解
class Solution {
    public boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }
        int[] factors = {2, 3, 5};
        for (int factor : factors) {
            while (n % factor == 0) {
                n /= factor;
            }
        }
        return n == 1;
    }
}

