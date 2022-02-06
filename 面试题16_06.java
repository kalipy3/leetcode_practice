/*
 * 面试题16_06.java
 * Copyright (C) 2022 2022-02-03 09:47 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
//双指针 请直接看代码 简单
class Solution {
 public int smallestDifference(int[] a, int[] b) {

        Arrays.sort(a);
        Arrays.sort(b);

        int i = 0,j = 0;
        long min = Long.MAX_VALUE;

        while (i < a.length && j <b.length) {
            if (a[i] == b[j]) return 0;
            else if (a[i] > b[j]) {
                min = Math.min(min,(long) a[i] -(long) b[j]);
                j ++;
            } else {
                min = Math.min(min,(long) b[j] -(long) a[i]);
                i ++;
            }
        }
        return (int)min;
    }
}


