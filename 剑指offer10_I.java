/*
 * 剑指offer10_I.java
 * Copyright (C) 2022 2022-02-17 23:10 kalipy <kalipy@debian> 3069087972@qq.com
 *
 * Distributed under terms of the MIT license.
 */

链接：https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/solution/jian-zhi-offer-10-i-fei-bo-na-qi-shu-lie-1yxx/
//写法一
class Solution {

    int[] memory;

    public int fib(int n) {
        memory = new int[n+1];
        return help(n);
    }

    public int help(int n) {
        // 递归结束的条件
        if (n <= 1) {
            return n;
        }

        // 判断是否计算过了
        if (memory[n] != 0) {
            return memory[n];
        }

        // 没有在 memory 中找到就计算一下，然后在记录到 memory 中
        int i = help(n - 1) + help(n - 2);
        i %= 1000000007;
        memory[n] = i;

        return memory[n];
    }
}

//写法二
class Solution {
    public int fib(int n) {
        if (n < 2) {
            return n;
        }

        int a = 1;
        int b = 1;

        for (int i = 2; i < n; i++) {
            int temp = (a + b);
            a = b;
            b = temp;
            b %= 1000000007;
        }

        return b;
    }
}

//写法三 kalipy一次过  推荐
class Solution {

    public int fib(int n) {
        if (n <= 1) return n;
        int a = 0;
        int b = 1;

        for (int i = 2; i <= n; i++) {
            int c = a + b;
            a = b;
            b = c % 1000000007;
        }

        return b;
    }
}
//f(n): 0 1 1 2
//n:    0 1 2 3
