/*
 * MainClass179.java
 * Copyright (C) 2022 2022-02-17 22:52 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */

链接：https://leetcode-cn.com/problems/largest-number/solution/gong-shui-san-xie-noxiang-xin-ke-xue-xi-vn86e/
//要想组成最大的整数，一种直观的想法是把数值大的数放在高位。于是我们可以比较输入数组的每个元素的最高位，最高位相同的时候比较次高位，以此类推，完成排序，然后把它们拼接起来。这种排序方式对于输入数组 没有相同数字开头 的时候是有效的，例如 [45,56,81,76,123]。
//
//下面考虑输入数组 有相同数字开头 的情况，例如 [4,42] 和 [4,45]。
//
//    对于 [4,42]，比较 442>424，需要把 4 放在前面；
//    对于 [4,45]，比较 445<454，需要把 45 放在前面。
//
//因此我们需要比较两个数不同的拼接顺序的结果，进而决定它们在结果中的排列顺序。
class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] ss = new String[n];
        for (int i = 0; i < n; i++) ss[i] = "" + nums[i];
        Arrays.sort(ss, (a, b) -> {
            String sa = a + b, sb = b + a ;
            return sb.compareTo(sa);
        });

        StringBuilder sb = new StringBuilder();
        for (String s : ss) sb.append(s);
        int len = sb.length();
        int k = 0;
        while (k < len - 1 && sb.charAt(k) == '0') k++;
        return sb.substring(k);
    }
}


