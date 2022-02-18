/*
 * MainClass167.java
 * Copyright (C) 2022 2022-02-16 15:13 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */
//请直接看代码 送分题
class Solution {
    public int[] twoSum(int[] numbers, int target) {

        int L = 0;
        int R = numbers.length - 1;

        while (L < R) {
            int sum = numbers[L] + numbers[R];
            if (sum == target) {
                return new int[]{L+1, R+1};
            }
            if (sum < target) {
                L++;
            }
            if (sum > target) {
                R--;
            }
        }
        return new int[]{-1, -1};
    }
}
